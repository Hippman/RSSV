package reports;

import group.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.chart.PieChartModel;
import rows.DDRRow;
import rows.UserRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class DDRReport {
    private String user;
    private Date datefrom,dateto;
    private List <String> users;
    private List <DDRRow> rows;
    private Connection connection;
    private PieChartModel pieModel;
    private String Login;
    private Boolean pollDisabled;
    private int interval;
    public DDRReport() {
        interval=0;
        pollDisabled=false;
        rows=new ArrayList<>();
        this.dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        connection=ConnectionManager.getConnectionDDR();
        
        users=new ArrayList<>();
        user="";
        pieModel = new PieChartModel();
    }
    public void genReport(){
        String[] operations={"NNMP", "OCN", "OCNName", "SPID", "FullDataJSON", "FullDataTEXT", "Category", "LRN", "FullDataTEXTCoSpec", "FullDataJSONCoSpec"};
        List <UserRow> ousers;
        rows=new ArrayList<>();
        Integer userid=0;
        Calendar calFrom=Calendar.getInstance();
        Calendar calTo=Calendar.getInstance();
        calFrom.setTime(datefrom);
        calTo.setTime(dateto);
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

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<DDRRow> getRows() {
        return rows;
    }

    public void setRows(List<DDRRow> rows) {
        this.rows = rows;
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

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
     
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
    
    
    public Boolean isPollDisabled() {
        return true;
    }

    public void setPollDisabled(Boolean pollDisabled) {
        this.pollDisabled = pollDisabled;
    }
    
}
