package rows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valeriy Surjenko Onvoy inc.
 */
public class Row 
{
    private TimeZone timezone;
    private String user;
    private String date;
    private Integer total;
    private Integer lrn;
    private Integer category;
    private Integer full;
    private Integer ocn;
    private Integer ocnname;
    private Integer spid;
    private Integer lrnjurisdiction;
    private Integer jurisdiction;
    private Integer fullcospec;
    private Integer nnmp;
    {
        user="";
        date="";
        total=0;
        lrn=0;
        category=0;
        full=0;
        ocn=0;
        ocnname=0;
        spid=0;
        lrnjurisdiction=0;
        jurisdiction=0;
        fullcospec=0;
        nnmp=0;
    }
    
    public Row(String user, String date, Integer total, Integer lrn, Integer category, 
            Integer full, Integer ocn, Integer ocnname, Integer spid, Integer lrnjurisdiction,
            Integer jurisdiction, Integer fullcospec, Integer nnmp, TimeZone timezone) {
        this.user = user;
        this.date = date;
        this.total = total;
        this.lrn = lrn;
        this.category = category;
        this.full = full;
        this.ocn = ocn;
        this.ocnname = ocnname;
        this.spid = spid;
        this.lrnjurisdiction=lrnjurisdiction;
        this.jurisdiction=jurisdiction;
        this.fullcospec=fullcospec;
        this.timezone=timezone;
        this.nnmp=nnmp;
    }

    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate()  {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLrn() {
        return lrn;
    }

    public void setLrn(Integer lrn) {
        this.lrn = lrn;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getFull() {
        return full;
    }

    public void setFull(Integer full) {
        this.full = full;
    }

    public Integer getOcn() {
        return ocn;
    }

    public void setOcn(Integer ocn) {
        this.ocn = ocn;
    }

    public Integer getOcnname() {
        return ocnname;
    }

    public void setOcnname(Integer ocnname) {
        this.ocnname = ocnname;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getLrnjurisdiction() {
        return lrnjurisdiction;
    }

    public void setLrnjurisdiction(Integer lrnjurisdiction) {
        this.lrnjurisdiction = lrnjurisdiction;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getFullcospec() {
        return fullcospec;
    }

    public void setFullcospec(Integer fullcospec) {
        this.fullcospec = fullcospec;
    }

    public Integer getNnmp() {
        return nnmp;
    }

    public void setNnmp(Integer nnmp) {
        this.nnmp = nnmp;
    }
    
    
}
