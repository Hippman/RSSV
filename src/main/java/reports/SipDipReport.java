package reports;

import com.lowagie.text.Document;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rows.SipDipReportRow;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Valeriy Surjenko.
 */
public class SipDipReport {
    private Date datefrom,dateto;
    private List <String> customres;
    private String customer;
    private List <SipDipReportRow> rows;
    private Integer total;
    private Connection connection;
    private boolean reportGenerated;
    public SipDipReport() {
        this.dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        rows=new ArrayList<SipDipReportRow>();
        customres=new ArrayList<String>();
        total=0;
        
        FillUsers();
        reportGenerated=false;
    }
    private void FillUsers(){
        rows.clear();

    }
    public void gen_report(){
        rows.clear();   
    }
    public void postProcessPDF(Object document)  {
        if(reportGenerated){
            try {
                Document pdf = (Document) document;
                Paragraph par = new Paragraph("Total: "+String.valueOf(total));
                par.setAlignment(Element.ALIGN_CENTER);
                pdf.add(par);
            } catch (DocumentException ex) {
                Logger.getLogger(SipDipReport.class.getName()).log(Level.SEVERE, null, ex);
            }
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
         

            sheet.setColumnWidth(5, 3500);
          
            cell=sheet.getRow(1).getCell(5);
            cell.setCellValue(String.format("%d", total));
          

            sheet.getRow(0).getCell(0).setCellStyle(cellStyle);
            sheet.getRow(0).getCell(1).setCellStyle(cellStyle);
            sheet.getRow(0).getCell(2).setCellStyle(cellStyle);
            sheet.getRow(0).getCell(5).setCellStyle(cellStyle);
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

    public List<String> getCustomres() {
        return customres;
    }

    public void setCustomres(List<String> customres) {
        this.customres = customres;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<SipDipReportRow> getRows() {
        return rows;
    }

    public void setRows(List<SipDipReportRow> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
