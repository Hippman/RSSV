
package reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;
import rows.PieReportRow;
/**
 *
 * @author Valeriy Surjenko.
 */
public class PieReport {
    private String user;
    private Date datefrom,dateto;
    private Integer bound;
    private List <String> users;
    private List <PieReportRow> rows;
    private Connection connection;
    private PieChartModel pieModel;
    private TimeZone timezone;
    private String Login;
    
    public PieReport(String user, Date datefrom, Date dateto, Integer bound) {
        this.user = user;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.bound = bound;
        connection=ConnectionManager.getConnection();
        //users=Users.FillUsers(connection,"");
        //user=users.get(0);
        users=new ArrayList<>();
        user="";
        pieModel = new PieChartModel();
        timezone=Calendar.getInstance().getTimeZone();
        Login="";
    }

    public PieReport() {
        this.dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        bound=10;
        user="";
        connection=ConnectionManager.getConnection();
        users=new ArrayList<>();
        pieModel = new PieChartModel();
        timezone=Calendar.getInstance().getTimeZone();
        Login="";
    }
    
    public void genReport(){
        pieModel = new PieChartModel();
        rows=new ArrayList<PieReportRow>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //df.setTimeZone(timezone);
        pieModel.set("test", 100);
        pieModel.set("test2", 50);

        String reportName="Pie report for "+user+" ("+df.format(datefrom)+" to "+df.format(dateto)+")";
        pieModel.setTitle(reportName);
        pieModel.setLegendPosition("w");
        pieModel.setShadow(true);

    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public List<PieReportRow> getRows() {
        return rows;
    }

    public void setRows(List<PieReportRow> rows) {
        this.rows = rows;
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
    public void setLogin(String Login) {
        this.Login = Login;
       
    }
    
}
