
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
import rows.StatsAralocRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class R2AsrAlocReport {
    private Date datefrom,dateto;
    private List <StatsAralocRow> rows;
    private Connection connection;
    private String groupby;
    private Double AttemptsTotal;
    private Double AnsweredTotal;
    private Double AsrTotal;
    private Double AlocTotal;
    private Double SecondsTotal;
    private Boolean ReportGenrated;
    public R2AsrAlocReport() {
        ReportGenrated=false;
        connection=ConnectionManager.getConnectionRespPie();
        rows=new ArrayList<>();
        dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        this.groupby="No group";
        AttemptsTotal=0.0;
        AnsweredTotal=0.0;
        AsrTotal=0.0;
        AlocTotal=0.0;
        SecondsTotal=0.0;
        
    }
     public void gen_report() {

        ReportGenrated=true;
        AttemptsTotal=0.0;
        AnsweredTotal=0.0;
        AsrTotal=0.0;
        AlocTotal=0.0;
        SecondsTotal=0.0;

        rows=new ArrayList<>();
           
     }
    public void postProcessXLS(Object document) {
        if(ReportGenrated){
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
                for(int b=0;b<8;b++){
                     sheet.getRow(a).createCell(b);
                }
            }
            cell=sheet.getRow(rows.size()+1).getCell(0);
            cell.setCellValue("Total");
            cell=sheet.getRow(rows.size()+2).getCell(1);
            cell.setCellValue("Attempts");
            cell=sheet.getRow(rows.size()+2).getCell(2);
            cell.setCellValue("AnsweredTotal");
            cell=sheet.getRow(rows.size()+2).getCell(3);
            cell.setCellValue("ASR");
            cell=sheet.getRow(rows.size()+2).getCell(4);
            cell.setCellValue("ALOC");
            
            cell=sheet.getRow(rows.size()+3).getCell(1);
            cell.setCellValue(AttemptsTotal);
            cell=sheet.getRow(rows.size()+3).getCell(2);
            cell.setCellValue(AnsweredTotal);
            cell=sheet.getRow(rows.size()+3).getCell(3);
            cell.setCellValue(AsrTotal);
            cell=sheet.getRow(rows.size()+3).getCell(4);
            cell.setCellValue(AlocTotal);         
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

    public List<StatsAralocRow> getRows() {
        return rows;
    }

    public void setRows(List<StatsAralocRow> rows) {
        this.rows = rows;
    }

    public String getGroupby() {
        return groupby;
    }

    public void setGroupby(String groupby) {
        this.groupby = groupby;
    }

    public Double getAttemptsTotal() {
        return AttemptsTotal;
    }

    public void setAttemptsTotal(Double AttemptsTotal) {
        this.AttemptsTotal = AttemptsTotal;
    }

    public Double getAnsweredTotal() {
        return AnsweredTotal;
    }

    public void setAnsweredTotal(Double AnsweredTotal) {
        this.AnsweredTotal = AnsweredTotal;
    }

    public String getAsrTotal() {
        return String.format("%.2f", AsrTotal);
    }

    public void setAsrTotal(Double AsrTotal) {
        this.AsrTotal = AsrTotal;
    }

    public String getAlocTotal() {
        return String.format("%.2f",AlocTotal);
    }

    public void setAlocTotal(Double AlocTotal) {
        this.AlocTotal = AlocTotal;
    }

    public Double getSecondsTotal() {
        return SecondsTotal;
    }

    public void setSecondsTotal(Double SecondsTotal) {
        this.SecondsTotal = SecondsTotal;
    }
    
}   
