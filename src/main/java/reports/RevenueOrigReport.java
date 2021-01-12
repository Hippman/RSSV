package reports;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
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
import rows.RevenueOrigReportRow;


/**
 *
 * @author Valeriy Surjenko.
 */
public class RevenueOrigReport {
    private Date datefrom,dateto;
    private List <RevenueOrigReportRow> rows;
    private Connection connection;
    private String groupby;
    
    private Integer R2AttemptsTotal;
    private Integer R2AnsweredTotal;
    private Double R2ASRTotal;
    private Double R2AllocTotal;
    private Double R2RatePerMinTotal;
    private Double R2RevenueTotal;
    
    private Integer BtAttemptsTotal;
    private Integer BtAnsweredTotal;
    private Double BtASRTotal;
    private Double BtAllocTotal;
    private Double BtRatePerMinTotal;
    private Double BtRevenueTotal;
    
    private Long r2secondsTotal;
    private Long btsecondsTotal;
    
    private boolean reportGenerated;
    public RevenueOrigReport() {
        connection=ConnectionManager.getConnectionRespPie();
        rows=new ArrayList<>();
        dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        reportGenerated=false;
        R2AttemptsTotal=0;
        R2AnsweredTotal=0;
        R2ASRTotal=0.0;
        R2AllocTotal=0.0;
        R2RatePerMinTotal=0.0;
        R2RevenueTotal=0.0;
        BtAttemptsTotal=0;
        BtAnsweredTotal=0;
        BtASRTotal=0.0;
        BtAllocTotal=0.0;
        BtRatePerMinTotal=0.0;
        BtRevenueTotal=0.0;
    }
    public void gen_report() {
       
         
            rows=new ArrayList<>();
            R2AttemptsTotal=0;
            R2AnsweredTotal=0;
            R2ASRTotal=0.0;
            R2AllocTotal=0.0;
            R2RatePerMinTotal=0.0;
            R2RevenueTotal=0.0;
            BtAttemptsTotal=0;
            BtAnsweredTotal=0;
            BtASRTotal=0.0;
            BtAllocTotal=0.0;
            BtRatePerMinTotal=0.0;
            BtRevenueTotal=0.0;
            r2secondsTotal=Long.valueOf(0);
            btsecondsTotal=Long.valueOf(0);
          
    }
    public void postProcessXLS(Object document) {
        if(reportGenerated){
            HSSFWorkbook wb = (HSSFWorkbook) document;
            HSSFSheet sheet = wb.getSheetAt(0);
            
            //sheet.createRow(0);
            sheet.createRow(rows.size()+1);
            sheet.createRow(rows.size()+2);
            sheet.createRow(rows.size()+3);
            
            for (int a=rows.size()+1;a<=rows.size()+3;a++){
                for(int b=0;b<16;b++){
                     sheet.getRow(a).createCell(b);
                }
            }
            sheet.getRow(0).createCell(0);
            sheet.getRow(0).createCell(8);
            
            sheet.getRow(rows.size()+1).createCell(6);
            sheet.getRow(rows.size()+1).createCell(8);
            sheet.getRow(rows.size()+1).createCell(14);
            sheet.getRow(rows.size()+1).createCell(15);
            
            HSSFCellStyle cellStyle = wb.createCellStyle();  
            HSSFFont font= wb.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            cellStyle.setFont(font);
            HSSFCell  cell=sheet.getRow(0).getCell(0);
            /*cell.setCellValue("R2 ORIGINATED");
            cell.setCellStyle(cellStyle);    
            cell=sheet.getRow(0).getCell(8);
            cell.setCellValue("BT ORIGINATED");
            cell.setCellStyle(cellStyle);   */
            
               
            cell=sheet.getRow(0).getCell(0);
            cell.setCellValue("Outbound trunk");
            cell=sheet.getRow(0).getCell(1);
            cell.setCellValue("Routing type");
            cell=sheet.getRow(0).getCell(8);
            cell.setCellValue("Minutes");
            
            cell=sheet.getRow(rows.size()+1).getCell(2);
            cell.setCellValue("R2 Originated Total");
            cell=sheet.getRow(rows.size()+1).getCell(8);
            cell.setCellValue("BT ORIGINATED Total");
         
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
            cell=sheet.getRow(rows.size()+2).getCell(9);
            cell.setCellValue("Attempts");
            cell=sheet.getRow(rows.size()+2).getCell(10);
            cell.setCellValue("Answered");
            cell=sheet.getRow(rows.size()+2).getCell(11);
            cell.setCellValue("ASR");
            cell=sheet.getRow(rows.size()+2).getCell(12);
            cell.setCellValue("ALOC");
            cell=sheet.getRow(rows.size()+2).getCell(13);
            cell.setCellValue("Rate per min");
            cell=sheet.getRow(rows.size()+2).getCell(14);
            cell.setCellValue("Revenue");
            cell=sheet.getRow(rows.size()+2).getCell(15);
            cell.setCellValue("Minutes");
            
            cell=sheet.getRow(rows.size()+3).getCell(2);
            cell.setCellValue(R2AttemptsTotal);
            cell=sheet.getRow(rows.size()+3).getCell(3);
            cell.setCellValue(R2AnsweredTotal);
            cell=sheet.getRow(rows.size()+3).getCell(4);
            cell.setCellValue(R2ASRTotal);
            cell=sheet.getRow(rows.size()+3).getCell(5);
            cell.setCellValue(R2AllocTotal);
            cell=sheet.getRow(rows.size()+3).getCell(6);
            cell.setCellValue(R2RatePerMinTotal);
            cell=sheet.getRow(rows.size()+3).getCell(7);
            cell.setCellValue(R2RevenueTotal);
            cell=sheet.getRow(rows.size()+3).getCell(8);
            cell.setCellValue(r2secondsTotal/60);
            cell=sheet.getRow(rows.size()+3).getCell(9);
            cell.setCellValue(R2AttemptsTotal);
            cell=sheet.getRow(rows.size()+3).getCell(10);
            cell.setCellValue(BtAnsweredTotal);
            cell=sheet.getRow(rows.size()+3).getCell(11);
            cell.setCellValue(BtASRTotal);
            cell=sheet.getRow(rows.size()+3).getCell(12);
            cell.setCellValue(BtAllocTotal);
            cell=sheet.getRow(rows.size()+3).getCell(13);
            cell.setCellValue(BtRatePerMinTotal);
            cell=sheet.getRow(rows.size()+3).getCell(14);
            cell.setCellValue(BtRevenueTotal);
            cell=sheet.getRow(rows.size()+3).getCell(15);
            cell.setCellValue(btsecondsTotal/60);
           

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

    public List<RevenueOrigReportRow> getRows() {
        return rows;
    }

    public void setRows(List<RevenueOrigReportRow> rows) {
        this.rows = rows;
    }

    public Integer getR2AttemptsTotal() {
        return R2AttemptsTotal;
    }

    public void setR2AttemptsTotal(Integer R2AttemptsTotal) {
        this.R2AttemptsTotal = R2AttemptsTotal;
    }

    public Integer getR2AnsweredTotal() {
        return R2AnsweredTotal;
    }

    public void setR2AnsweredTotal(Integer R2AnsweredTotal) {
        this.R2AnsweredTotal = R2AnsweredTotal;
    }

    public String getR2ASRTotal() {
        return String.format("%.1f", R2ASRTotal);
    }

    public void setR2ASRTotal(Double R2ASRTotal) {
        this.R2ASRTotal = R2ASRTotal;
    }

    public String getR2AllocTotal() {
        return String.format("%.2f",R2AllocTotal);
    }

    public void setR2AllocTotal(Double R2AllocTotal) {
        this.R2AllocTotal = R2AllocTotal;
    }

    public String getR2RatePerMinTotal() {
        return String.format("%.4f",R2RatePerMinTotal);
    }

    public void setR2RatePerMinTotal(Double R2RatePerMinTotal) {
        this.R2RatePerMinTotal = R2RatePerMinTotal;
    }

    public String getR2RevenueTotal() {
        return String.format("%.2f",R2RevenueTotal);
    }

    public void setR2RevenueTotal(Double R2RevenueTotal) {
        this.R2RevenueTotal = R2RevenueTotal;
    }

    public Integer getBtAttemptsTotal() {
        return BtAttemptsTotal;
    }

    public void setBtAttemptsTotal(Integer BtAttemptsTotal) {
        this.BtAttemptsTotal = BtAttemptsTotal;
    }

    public Integer getBtAnsweredTotal() {
        return BtAnsweredTotal;
    }

    public void setBtAnsweredTotal(Integer BtAnsweredTotal) {
        this.BtAnsweredTotal = BtAnsweredTotal;
    }

    public String getBtASRTotal() {
        return String.format("%.1f", BtASRTotal);
    }

    public void setBtASRTotal(Double BtASRTotal) {
        this.BtASRTotal = BtASRTotal;
    }

    public String getBtAllocTotal() {
        return String.format("%.2f",BtAllocTotal);
    }

    public void setBtAllocTotal(Double BtAllocTotal) {
        this.BtAllocTotal = BtAllocTotal;
    }

    public String getBtRatePerMinTotal() {
        return String.format("%.4f",BtRatePerMinTotal);
    }

    public void setBtRatePerMinTotal(Double BtRatePerMinTotal) {
        this.BtRatePerMinTotal = BtRatePerMinTotal;
    }

    public String getBtRevenueTotal() {
        return String.format("%.2f",BtRevenueTotal);
    }

    public void setBtRevenueTotal(Double BtRevenueTotal) {
        this.BtRevenueTotal = BtRevenueTotal;
    }

    public boolean isReportGenerated() {
        return reportGenerated;
    }

    public void setReportGenerated(boolean reportGenerated) {
        this.reportGenerated = reportGenerated;
    }

    public Long getR2secondsTotal() {
        if (r2secondsTotal!=null){
            return r2secondsTotal/60;
        }
        return r2secondsTotal;
    }

    public void setR2secondsTotal(Long r2secondsTotal) {
        this.r2secondsTotal = r2secondsTotal;
    }

    public Long getBtsecondsTotal() {
        if (btsecondsTotal!=null){
            return btsecondsTotal/60;
        }
        return btsecondsTotal;
    }

    public void setBtsecondsTotal(Long btsecondsTotal) {
        this.btsecondsTotal = btsecondsTotal;
    }
    
    
    
   
}

