
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgRow {
    private String resporg;
    private String CName;
    private String TN;
    private String CIC;

    public String getResporg() {
        return resporg;
    }

    public void setResporg(String resporg) {
        this.resporg = resporg;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getTN() {
        return TN;
    }

    public void setTN(String TN) {
        this.TN = TN;
    }

    public String getCIC() {
        return CIC;
    }

    public void setCIC(String CIC) {
        this.CIC = CIC;
    }

    public ResporgRow(String resporg, String CName, String TN, String CIC) {
        this.resporg = resporg;
        this.CName = CName;
        this.TN = TN;
        this.CIC = CIC;
    }

    
   

    
     
}
