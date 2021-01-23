
package reports;

import rows.ChartRow;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;

import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;


/**
 *
 * @author Valeriy Surjenko.
 */
public class ChartDynamic {
    private String header;
    private int timeDif;
    private LineChartModel lineModel1;
    private TimeZone timezone;
    private List <ChartRow> rows;
    private Connection connection;
    private Date datefrom,dateto,datefrombuf,datetobuf;
    private String tz;
    private String user;
    private Double rate;
    private String groupby,groupbybuf;
    private Boolean collapsed;
    private List <String> users;
    private List <Double> rates;
    private Double total,runRate,runTotal;
    private DefaultCategoryDataset  dataset1;
    private DefaultCategoryDataset  dataset2;
    private boolean reportGenerated;
    private String Login;
    public ChartDynamic()
    {
        timezone=Calendar.getInstance().getTimeZone();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        dateto=new Date();
        datefrombuf=new Date();
        datetobuf=new Date();
        rows=new ArrayList<ChartRow>();
        groupby="Hour";
        groupbybuf=groupby;
        users=new ArrayList<String>();
        rates=new ArrayList<Double>();
       
        collapsed=false;
        connection=ConnectionManager.getConnection();
        lineModel1 = new LineChartModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10000);
        total=0.0;
        runTotal=0.0;
        runRate=0.0;
        
        dataset2=new DefaultCategoryDataset();
        dataset1=new DefaultCategoryDataset();
        reportGenerated=false;
    }


    public void FillUsers(Connection con)
    {
        users.clear();
        rates.clear();
        
    }
    private void fillCal(Calendar cal, ResultSet res) throws SQLException{
        cal.set(Calendar.DAY_OF_MONTH, res.getInt("day"));
        cal.set(Calendar.HOUR_OF_DAY, res.getInt("hour"));
    }
    private void doquery2(String sql,String name)
    {
        LineChartModel model = new LineChartModel();
        model.setLegendPosition("ne");
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Total");
        series1.setShowLine(true);
        series1.setSmoothLine(true);
        LineChartSeries series2 = new LineChartSeries();
        series2.setShowLine(true);
        series2.setLabel("Charge");
        series2.setYaxis(AxisType.Y2);
        series2.setSmoothLine(true);

        model.addSeries(series2);
        model.addSeries(series1);

        lineModel1 = model;
        lineModel1.setTitle("Hour chart");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Dips");
        yAxis.setMin(0);
        Axis y2Axis = new LinearAxis("Charge");
        y2Axis.setMin(-10);
        DateAxis axis = new DateAxis("Dates");
        lineModel1.getAxes().put(AxisType.Y2, y2Axis);
        lineModel1.getAxes().put(AxisType.X, axis);
        lineModel1.setShowPointLabels(false);
        reportGenerated=true;
     
        
    }  
    
    public void gen_report()
    {
            datefrombuf=datefrom;
            datetobuf=dateto;
            String dfrom,dto;
            String sql;
            Date bufdat,bufdat2;
            groupbybuf=groupby;
      
            rows.clear();
         
            collapsed=true;
    }
     public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        if(reportGenerated){
            Document pdf = (Document) document;
            pdf.open();

            Font fnt = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, Color.BLACK); 
            Paragraph par = new Paragraph(header, fnt);
            par.setAlignment(Element.ALIGN_CENTER);


            pdf.add(par);
            Paragraph par2 = new Paragraph(" ", fnt);
            pdf.add(par2);
        }
    }
    public void postProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        if(reportGenerated){
            Document pdf = (Document) document;
            Paragraph par = new Paragraph("Total: "+String.valueOf(total));
            par.setAlignment(Element.ALIGN_CENTER);
            pdf.add(par);
            par = new Paragraph("Run total: "+String.valueOf(runTotal));
            par.setAlignment(Element.ALIGN_CENTER);
            pdf.add(par);
            par = new Paragraph("Run rate: "+String.valueOf(runRate));
            par.setAlignment(Element.ALIGN_CENTER);
            pdf.add(par);

            JFreeChart jfreechart = ChartFactory.createLineChart("Dips","Date","Dips",dataset1);
            ByteArrayOutputStream str=new ByteArrayOutputStream();
            ChartUtils.writeChartAsPNG(str, jfreechart, 500, 400, true,0);
            Image img=Image.getInstance(str.toByteArray());
            pdf.add(img);      
            jfreechart = ChartFactory.createLineChart("Rate","Date","Rate",dataset2);
            str=new ByteArrayOutputStream();
            ChartUtils.writeChartAsPNG(str, jfreechart, 500, 400, true,0);
            img=Image.getInstance(str.toByteArray());
            pdf.add(img);  
        }
    }
    public void postProcessXLS(Object document) {
        if(reportGenerated){
            HSSFWorkbook wb = (HSSFWorkbook) document;
            HSSFSheet sheet = wb.getSheetAt(0);
            for(int a=0;a<2;a++){
                for(int b=5;b<=7;b++) {
                    sheet.getRow(a).createCell(b);
                }
            }
            HSSFCellStyle cellStyle = wb.createCellStyle();  
            HSSFFont font= wb.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            cellStyle.setFont(font);


            HSSFCell  cell=sheet.getRow(0).getCell(5);
            cell.setCellValue("Total");
            cell.setCellStyle(cellStyle);
            cell=sheet.getRow(0).getCell(6);
            cell.setCellValue("Run total");
            cell.setCellStyle(cellStyle);
            cell=sheet.getRow(0).getCell(7);
            cell.setCellValue("Run rate");
            cell.setCellStyle(cellStyle);

            sheet.setColumnWidth(5, 3600);
            sheet.setColumnWidth(6, 3600);
            sheet.setColumnWidth(7, 3600);
            cell=sheet.getRow(1).getCell(5);
            cell.setCellValue(String.format("%.0f", total));
            cell=sheet.getRow(1).getCell(6);
            cell.setCellValue(String.format("%.4f", runTotal));
            cell=sheet.getRow(1).getCell(7);
            cell.setCellValue(String.format("%,4f", runRate));

            for(int a=0;a<4;a++){
                sheet.getRow(0).getCell(a).setCellStyle(cellStyle);
            }
        }
        
    }
    
    public List<ChartRow> getRows() {
        return rows;
    }

    public void setRows(List<ChartRow> rows) {
        this.rows = rows;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGroupby() {
        return groupby;
    }

    public void setGroupby(String groupby) {
        this.groupby = groupby;
    }

    public Boolean getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(Boolean collapsed) {
        this.collapsed = collapsed;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
    public TimeZone getTimeZone() {  
        return timezone;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRunRate() {
        return String.format("$%.6f", runRate);
    }

    public void setRunRate(Double runRate) {
        this.runRate = runRate;
    }

    public String getRunTotal() {
        return String.format("%.2f", runTotal);
    }

    public void setRunTotal(Double runTotal) {
        this.runTotal = runTotal;
    }
    
    
    
    
    public String getTimezone() {
        return timezone.toString();
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }
    
    public void setTimezone(String timezone) {
        
        if(timezone.length()>0) {
            Integer offset;
            try {
                offset=Integer.parseInt(timezone)*60000*(-1);
                this.timezone=TimeZone.getTimeZone("GMT");
                this.timezone.setRawOffset(offset);
            } catch (Exception ex){};
        }

    }
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }
    public void setLogin(String Login) {
        this.Login = Login;
    }
}
