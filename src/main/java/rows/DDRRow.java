package rows;

import java.util.Date;

/**
 *
 * @author Valeriy Surjenko.
 */
public class DDRRow {
    private Integer userId;
    private String ip;
    private String ddrdate;
    private String operation;
    private String tn;
    private String lrn;
    private String callid;

    public DDRRow(Integer userId, String ip, String ddrdate, String operation, String tn, String lrn, String callid) {
        this.userId = userId;
        this.ip = ip;
        this.ddrdate = ddrdate;
        this.operation = operation;
        this.tn = tn;
        this.lrn = lrn;
        this.callid = callid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDdrdate() {
        return ddrdate;
    }

    public void setDdrdate(String ddrdate) {
        this.ddrdate = ddrdate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getLrn() {
        return lrn;
    }

    public void setLrn(String lrn) {
        this.lrn = lrn;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }
    
}

