package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgPieRow {
    private String resporg;
    private int minutes;
    private int count;
    private String cname;
    private String cic;
    private String cicName;
    

    public ResporgPieRow( String resporg, int minutes, int count) {
        this.resporg = resporg;
        this.minutes = minutes;
        this.count = count;
        this.cic="";
        this.cicName="";
    }
    public ResporgPieRow( String resporg) {
        this.resporg = resporg;
     }

    public String getResporg() {
        return resporg;
    }

    public void setResporg(String resporg) {
        this.resporg = resporg;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCic() {
        return cic;
    }

    public void setCic(String cic) {
        this.cic = cic;
    }

    public String getCicName() {
        return cicName;
    }

    public void setCicName(String cicName) {
        this.cicName = cicName;
    }
    
  
    
}
