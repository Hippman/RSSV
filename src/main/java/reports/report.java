
package reports;

/**
 *
 * @author VSurjenko
 */
public class report 
{
    private String date;
    private String report;
    private String customer_id;
    private String customer_name;

    public report() 
    {
        date="";
        report="";
        customer_id="";
        customer_name="";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    
    
}
