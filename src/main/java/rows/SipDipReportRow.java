
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class SipDipReportRow {
    private String date;
    private Integer count;
    private String custid;
    

    public SipDipReportRow() {
        date="20200101";
        count=0;
        custid="";
    }

    public SipDipReportRow(String date, Integer count, String custid) {
        this.date = date;
        this.count = count;
        this.custid=custid;
    }
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }
    
    
}
