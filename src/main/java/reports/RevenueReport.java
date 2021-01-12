package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import rows.REvenueReportRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class RevenueReport {
    private Date datefrom,dateto;
    private List <REvenueReportRow> rows;
    private Connection connection;
    private String groupby;
    private Double total;
    private boolean reportGenerated;
    private Integer AttemptsTotal;
    private Integer AnsweredTotal;
    private Double ASRTotal;
    private Double AllocTotal;
    private Double RatePerMinTotal;
    private Double RevenueTotal;
    private Long secondsTotal;
    public RevenueReport() {
        connection=ConnectionManager.getConnectionRespPie();
        rows=new ArrayList<>();
        dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        total=0.0;
        reportGenerated=false;
        AttemptsTotal=0;
        AnsweredTotal=0;
        ASRTotal=0.0;
        AllocTotal=0.0;
        RatePerMinTotal=0.0;
        RevenueTotal=0.0;
        secondsTotal=Long.valueOf(0);
    }
    public void gen_report() {
            AttemptsTotal=0;
            AnsweredTotal=0;
            ASRTotal=0.0;
            AllocTotal=0.0;
            RatePerMinTotal=0.0;
            RevenueTotal=0.0;
            secondsTotal=Long.valueOf(0);
           
            rows=new ArrayList<>();
            total=0.0;
            reportGenerated=true;
    }
    public void postProcessXLS(Object document) {
        if(reportGenerated){
            HSSFWorkbook wb = (HSSFWorkbook) document;
            HSSFSheet sheet = wb.getSheetAt(0);
            sheet.createRow(rows.size()+1);
            sheet.createRow(rows.size()+2);
            sheet.createRow(rows.size()+3);
            
            sheet.getRow(rows.size()+1).createCell(6);
            sheet.getRow(rows.size()+1).createCell(7);
            
            HSSFCellStyle cellStyle = wb.createCellStyle();  
            HSSFFont font= wb.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            cellStyle.setFont(font);
            HSSFCell  cell=sheet.getRow(0).getCell(0);
           
             for (int a=rows.size()+1;a<=rows.size()+3;a++){
                for(int b=0;b<12;b++){
                     sheet.getRow(a).createCell(b);
                }
            }
            cell=sheet.getRow(rows.size()+1).getCell(1);
            cell.setCellValue("Total");
            cell=sheet.getRow(rows.size()+2).getCell(2);
            cell.setCellValue("Attempts");
            cell=sheet.getRow(rows.size()+2).getCell(3);
            cell.setCellValue("Answered");
            cell=sheet.getRow(rows.size()+2).getCell(4);
            cell.setCellValue("ASR");
            cell=sheet.getRow(rows.size()+2).getCell(5);
            cell.setCellValue("ALOC");
            cell=sheet.getRow(rows.size()+2).getCell(6);
            cell.setCellValue("Rate per min");
            cell=sheet.getRow(rows.size()+2).getCell(7);
            cell.setCellValue("Revenue");
            cell=sheet.getRow(rows.size()+2).getCell(8);
            cell.setCellValue("Minutes");
            
            cell=sheet.getRow(rows.size()+3).getCell(2);
            cell.setCellValue(AttemptsTotal);
            cell=sheet.getRow(rows.size()+3).getCell(3);
            cell.setCellValue(AnsweredTotal);
            cell=sheet.getRow(rows.size()+3).getCell(4);
            cell.setCellValue(ASRTotal);
            cell=sheet.getRow(rows.size()+3).getCell(5);
            cell.setCellValue(AllocTotal);
            cell=sheet.getRow(rows.size()+3).getCell(6);
            cell.setCellValue(RatePerMinTotal);
            cell=sheet.getRow(rows.size()+3).getCell(7);
            cell.setCellValue(RevenueTotal);
            cell=sheet.getRow(rows.size()+3).getCell(8);
            cell.setCellValue(secondsTotal/60);

        }
        
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

    public List<REvenueReportRow> getRows() {
        return rows;
    }

    public void setRows(List<REvenueReportRow> rows) {
        this.rows = rows;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getGroupby() {
        return groupby;
    }

    public void setGroupby(String groupby) {
        this.groupby = groupby;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isReportGenerated() {
        return reportGenerated;
    }

    public void setReportGenerated(boolean reportGenerated) {
        this.reportGenerated = reportGenerated;
    }

    public Integer getAttemptsTotal() {
        return AttemptsTotal;
    }

    public void setAttemptsTotal(Integer AttemptsTotal) {
        this.AttemptsTotal = AttemptsTotal;
    }

    public Integer getAnsweredTotal() {
        return AnsweredTotal;
    }

    public void setAnsweredTotal(Integer AnsweredTotal) {
        this.AnsweredTotal = AnsweredTotal;
    }

    public String getASRTotal() {
        return String.format("%.1f", ASRTotal);
    }

    public void setASRTotal(Double ASRTotal) {
        this.ASRTotal = ASRTotal;
    }

    public String getAllocTotal() {
        return String.format("%.2f",AllocTotal);
    }

    public void setAllocTotal(Double AllocTotal) {
        this.AllocTotal = AllocTotal;
    }

    public String getRatePerMinTotal() {
        return String.format("%.4f", RatePerMinTotal);
    }

    public void setRatePerMinTotal(Double RatePerMinTotal) {
        this.RatePerMinTotal = RatePerMinTotal;
    }

    public String getRevenueTotal() {
        return String.format("%.2f", RevenueTotal);
    }

    public void setRevenueTotal(Double RevenueTotal) {
        this.RevenueTotal = RevenueTotal;
    }

    public Long getSecondsTotal() {
        if (secondsTotal!=null){
            return secondsTotal/60;
        } return secondsTotal;
    }

    public void setSecondsTotal(Long secondsTotal) {
        this.secondsTotal = secondsTotal;
    }
    
    
}
