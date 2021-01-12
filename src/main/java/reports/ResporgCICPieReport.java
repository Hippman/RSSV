package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;
import rows.PieReportRow;
import rows.ResporgPieRow;
import rows.ResporgRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgCICPieReport {
    private Date datefrom,dateto;
    private Integer bound;
    private List <ResporgPieRow> rows1,rows2;
    private HashMap<Integer,String> cicname;
    private HashMap<String,String> resporgCname;
    private Connection connection;
    private PieChartModel pieModel1,pieModel2;
    private boolean fullTable;
    
    private void FillCname(){
        cicname=new HashMap<Integer,String>();

    }
    public ResporgCICPieReport( Date datefrom, Date dateto, Integer bound, List<ResporgPieRow> rows, Connection connection, PieChartModel pieModel) {
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.bound = bound;
        this.rows1 = rows;
        this.rows2 = rows;
        this.connection = connection;
        this.pieModel1 = pieModel;
        this.pieModel2 = pieModel;
        fullTable=false;
        this.FillCname();
        
    }

    public ResporgCICPieReport() {
        this.dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        bound=10;
        connection=ConnectionManager.getConnectionRespPie();
        pieModel1 = new PieChartModel();
        pieModel2 = new PieChartModel();
        fullTable=false;
        this.FillCname();
    }
    
    public void genReport(){

            pieModel1 = new PieChartModel();
            pieModel2 = new PieChartModel();
            rows1=new ArrayList<ResporgPieRow>();
            rows2=new ArrayList<ResporgPieRow>();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            pieModel1.set("test", 100);
            pieModel2.set("test2", 50);
              
            String reportName="Pie Resporg & CIC report by minutes ("+df.format(datefrom)+" to "+df.format(dateto)+")";
            pieModel1.setTitle(reportName);
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(true);
            
            pieModel2.set("test", 100);
            pieModel2.set("test2", 50);
            reportName="Pie Resporg & CIC report by count ("+df.format(datefrom)+" to "+df.format(dateto)+")";
            pieModel2.setTitle(reportName);
            pieModel2.setLegendPosition("w");
            pieModel2.setShadow(true);
            
            
      
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

    public Integer getBound() {
        return bound;
    }

    public void setBound(Integer bound) {
        this.bound = bound;
    }

    public List<ResporgPieRow> getRows1() {
        return rows1;
    }

    public void setRows1(List<ResporgPieRow> rows1) {
        this.rows1 = rows1;
    }

    public List<ResporgPieRow> getRows2() {
        return rows2;
    }

    public void setRows2(List<ResporgPieRow> rows2) {
        this.rows2 = rows2;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }

    public boolean isFullTable() {
        return fullTable;
    }

    public void setFullTable(boolean fullTable) {
        this.fullTable = fullTable;
    }
    
    
    
}
