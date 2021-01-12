
package reports;

import rows.Row;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.util.TimeZone;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.*;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Valeriy Surjenko Onvoy inc.
 */
public class Statistics
{

    private int timeDif;
    private TimeZone timezone;
    private List <Row> rows;
    private Connection connection;
    private Date datefrom,dateto,datefrombuf,datetobuf;
    private String tz;
    private String user;
    private String groupby,groupbybuf;
    private Boolean collapsed;
    private List <String> users;
    private String Login;
    public Statistics()
    {
        //timezone="UTC+0";
        timezone=Calendar.getInstance().getTimeZone();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        dateto=new Date();
        datefrombuf=new Date();
        datetobuf=new Date();
        rows=new ArrayList<Row>();
        groupby="Hour";
        groupbybuf=groupby;
        //users=new ArrayList<String>();
        users=new ArrayList<>();
        collapsed=false;
        connection=ConnectionManager.getConnection();
        //FillUsers();
    }
    public void FillUsers()
    {

        users.clear();

    }
    private void fillCal(Calendar cal, ResultSet res) throws SQLException{
        cal.set(Calendar.YEAR, res.getInt("year"));
        cal.set(Calendar.MONTH, res.getInt("month")-1);
        cal.set(Calendar.DAY_OF_MONTH, res.getInt("day"));
        cal.set(Calendar.HOUR_OF_DAY, res.getInt("hour"));
        cal.set(Calendar.MINUTE, res.getInt("minutes"));
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
    public void download() 
    {
        String dfrom,dto;
        String out,sdat;
        int a,b,max;

        byte bt[];
        if (rows!=null) {
            try {
                OutputStream Out=null;
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
                Out = response.getOutputStream();
                response.setContentType("text/csv");
                //dfrom=String.valueOf(datefrombuf.getYear()+1900) +"-"+String.format("%02d",datefrombuf.getMonth()+1)+"-"+String.format("%02d",datefrombuf.getDate())+" "+String.format("%02d",datefrombuf.getHours())+":"+String.format("%02d",datefrombuf.getMinutes());
                //dto=String.valueOf(datetobuf.getYear()+1900) +"-"+String.format("%02d",datetobuf.getMonth()+1)+"-"+String.format("%02d",datetobuf.getDate())+" "+String.format("%02d",datetobuf.getHours())+":"+String.format("%02d",datetobuf.getMinutes());
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                //formatter.setTimeZone(timezone);
                dfrom=formatter.format(datefrombuf);
                dto=formatter.format(datetobuf);    
                response.addHeader("Content-Disposition", "attachment; filename=RestServiceStatistics.csv");
                
                out="";
                out+="Grouped by:,"+groupbybuf+"\n";
                out+="From:,"+dfrom+"\n";
                out+="To:,"+dto+"\n\n";
                out+="Date,User,Total,LRN,Category,Full,OCN,OCN Name,SPID,LRNJurisdiction,Jurisdiction,Fullcospec,nnmp\n";
                
                for(a=0;a<rows.size();a++)
                {
                    out+=rows.get(a).getDate()+","+
                            rows.get(a).getUser()+","+
                            rows.get(a).getTotal()+","+
                            rows.get(a).getLrn()+","+
                            rows.get(a).getCategory()+","+
                            rows.get(a).getFull()+","+
                            rows.get(a).getOcn()+","+
                            rows.get(a).getOcnname()+","+
                            rows.get(a).getSpid()+","+
                            rows.get(a).getLrnjurisdiction()+","+
                            rows.get(a).getJurisdiction()+","+
                            rows.get(a).getFullcospec()+
                            rows.get(a).getNnmp()+
                            "\n";
                }
                    out+="\n";
                    bt=out.getBytes();
                    Out.write(bt, 0, bt.length);
                    Out.flush();
                             
               
            } catch (IOException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
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
