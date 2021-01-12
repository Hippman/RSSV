package reports;

import java.util.ArrayList;
import java.util.List;
import rows.JSONLrn;
import rows.ResporgRow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgDipReport {
    private List <rows.ResporgRow> rows;
    private String tn;
    private String cgpn;
    
    public void genReport(){
        
        String resporg="";
        String cname,cic;
        cname="unknown";
        cic="unknown";
       
        rows.ResporgRow row;
      
        row=new ResporgRow("unknown", "unknown",tn,"unknown");
        rows.add(row);
        
    }
    
    public void clear(){
        rows.clear();
    }

    public ResporgDipReport() {
        rows=new ArrayList<rows.ResporgRow>();
        tn="";
    }

    public List<ResporgRow> getRows() {
        return rows;
    }

    public void setRows(List<ResporgRow> rows) {
        this.rows = rows;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getCgpn() {
        return cgpn;
    }

    public void setCgpn(String cgpn) {
        this.cgpn = cgpn;
    }
    
    
}
