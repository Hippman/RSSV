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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;
import rows.ResporgCopyRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgCopyReport {
    private Date datefrom,dateto;
    private List <ResporgCopyRow> rows;
    private Connection connection;
    private PieChartModel pieModel;
    private Double avg;
    private HashMap<String,String> resporgCname;
    private Long total;
    
    public ResporgCopyReport() {
        rows=new ArrayList<>();
        this.dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        connection=ConnectionManager.getConnectionRespPie();
        pieModel = new PieChartModel();
        avg=0.0;
        total=Long.valueOf(0);
        this.FillCname();
    }
    private void FillCname(){
        resporgCname=new HashMap<String,String>();
         
    }
    public void genReport(){
        rows=new ArrayList<>();
        Integer userid=0;
        Calendar calFrom=Calendar.getInstance();
        Calendar calTo=Calendar.getInstance();
        calFrom.setTime(datefrom);
        calTo.setTime(dateto);
        SimpleDateFormat dfTable=new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dfQuery=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql;
        avg=0.0;
        total=Long.valueOf(0);
        rows.clear();
         
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

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public List<ResporgCopyRow> getRows() {
        return rows;
    }

    public void setRows(List<ResporgCopyRow> rows) {
        this.rows = rows;
    }

    public String getAvg() {
        return String.format("%.2f", avg);
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
    
}
