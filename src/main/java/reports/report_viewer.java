
package reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSurjenko
 */
public class report_viewer 
{
    
    private List<String> customers;
    private List<String> ids;
    private List<String> dates;
    private String customer;
    private Date date;
    private String curdate;
    private String reporttext;
    public void load_report(String date)
    {
        reporttext="";
           
    }
    public void fill_reports()
    {
        dates.clear();
           
         
    }
    public report_viewer() 
    {
        customer="";
        curdate="";
        reporttext="";
        date=new Date();

            customers=new ArrayList<String>();
            ids=new ArrayList<String>();
            dates=new ArrayList<String>();
    
            dates=new ArrayList<String>();
        
    }


    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public String getCurdate() {
        return curdate;
    }

    public void setCurdate(String curdate) {
        this.curdate = curdate;
    }

    public String getReporttext() {
        return reporttext;
    }

    public void setReporttext(String reporttext) {
        this.reporttext = reporttext;
    }
    

    
    
}
