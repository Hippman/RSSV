
package rows;

import java.util.Date;

/**
 *
 * @author Valeriy Surjenko.
 */
public class cdrRow {
    private short calltype;
    private Date cdrdate;
    private int duration;
    private int ms_duration;
    private int setuptime;
    private String method;
    private String from_tag;
    private String to_tag;
    private String callid;
    private int code;
    private String reason;
    private String custip;
    private String egressfromuri;
    private String requri;
    private String desturi;
    private boolean sendpcharge;        
    private String pchargeheader;         
    private String egressvendorid;
    private String hostname;
    private String origcalling;
    private String calling;
    private String dialed;
    private String resporg;                                            
    private Double egressvendorrate;
    private String vendorip;
    private short vendorport; 

    public cdrRow(short calltype, Date cdrdate, int duration, int ms_duration, int setuptime, String method, String from_tag, String to_tag, String callid, int code, String reason, String custip, String egressfromuri, String requri, String desturi, boolean sendpcharge, String pchargeheader, String egressvendorid, String hostname, String origcalling, String calling, String dialed, String resporg, Double egressvendorrate, String vendorip, short vendorport) {
        this.calltype = calltype;
        this.cdrdate = cdrdate;
        this.duration = duration;
        this.ms_duration = ms_duration;
        this.setuptime = setuptime;
        this.method = method;
        this.from_tag = from_tag;
        this.to_tag = to_tag;
        this.callid = callid;
        this.code = code;
        this.reason = reason;
        this.custip = custip;
        this.egressfromuri = egressfromuri;
        this.requri = requri;
        this.desturi = desturi;
        this.sendpcharge = sendpcharge;
        this.pchargeheader = pchargeheader;
        this.egressvendorid = egressvendorid;
        this.hostname = hostname;
        this.origcalling = origcalling;
        this.calling = calling;
        this.dialed = dialed;
        this.resporg = resporg;
        this.egressvendorrate = egressvendorrate;
        this.vendorip = vendorip;
        this.vendorport = vendorport;
    }

    public cdrRow() {
    }

    public short getCalltype() {
        return calltype;
    }

    public void setCalltype(short calltype) {
        this.calltype = calltype;
    }

    public Date getCdrdate() {
        return cdrdate;
    }

    public void setCdrdate(Date cdrdate) {
        this.cdrdate = cdrdate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMs_duration() {
        return ms_duration;
    }

    public void setMs_duration(int ms_duration) {
        this.ms_duration = ms_duration;
    }

    public int getSetuptime() {
        return setuptime;
    }

    public void setSetuptime(int setuptime) {
        this.setuptime = setuptime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFrom_tag() {
        return from_tag;
    }

    public void setFrom_tag(String from_tag) {
        this.from_tag = from_tag;
    }

    public String getTo_tag() {
        return to_tag;
    }

    public void setTo_tag(String to_tag) {
        this.to_tag = to_tag;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCustip() {
        return custip;
    }

    public void setCustip(String custip) {
        this.custip = custip;
    }

    public String getEgressfromuri() {
        return egressfromuri;
    }

    public void setEgressfromuri(String egressfromuri) {
        this.egressfromuri = egressfromuri;
    }

    public String getRequri() {
        return requri;
    }

    public void setRequri(String requri) {
        this.requri = requri;
    }

    public String getDesturi() {
        return desturi;
    }

    public void setDesturi(String desturi) {
        this.desturi = desturi;
    }

    public boolean isSendpcharge() {
        return sendpcharge;
    }

    public void setSendpcharge(boolean sendpcharge) {
        this.sendpcharge = sendpcharge;
    }

    public String getPchargeheader() {
        return pchargeheader;
    }

    public void setPchargeheader(String pchargeheader) {
        this.pchargeheader = pchargeheader;
    }

    public String getEgressvendorid() {
        return egressvendorid;
    }

    public void setEgressvendorid(String egressvendorid) {
        this.egressvendorid = egressvendorid;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getOrigcalling() {
        return origcalling;
    }

    public void setOrigcalling(String origcalling) {
        this.origcalling = origcalling;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public String getDialed() {
        return dialed;
    }

    public void setDialed(String dialed) {
        this.dialed = dialed;
    }

    public String getResporg() {
        return resporg;
    }

    public void setResporg(String resporg) {
        this.resporg = resporg;
    }

    public Double getEgressvendorrate() {
        return egressvendorrate;
    }

    public void setEgressvendorrate(Double egressvendorrate) {
        this.egressvendorrate = egressvendorrate;
    }

    public String getVendorip() {
        return vendorip;
    }

    public void setVendorip(String vendorip) {
        this.vendorip = vendorip;
    }

    public short getVendorport() {
        return vendorport;
    }

    public void setVendorport(short vendorport) {
        this.vendorport = vendorport;
    }
    
    
}
