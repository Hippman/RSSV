package reports;

import java.util.ArrayList;
import java.util.List;
import rows.JSONLrn;

/**
 *
 * @author Valeriy Surjenko.
 */
public class DipReport {
    private List <rows.JSONLrn> rows;
    private String tn;
    
    public void genReport(){
        rows.JSONLrn ret=LrnDipRequest.Dip(tn);
        //rows.JSONLrn row=new rows.JSONLrn();
        rows.add(ret);
        //rows.add(row);
    }
    public String getFirstTN(){
        if (rows.size()>0){
            return rows.get(0).getTn();
        }
        return "";
    }
    public String getFirstLRN(){
        if (rows.size()>0){
            return rows.get(0).getLrn();
        }
        return "";
    }
    public String getFirstOCN(){
        if (rows.size()>0){
            return rows.get(0).getOcn();
        }
        return "";
    }
    public String getFirstOcnName(){
        if (rows.size()>0){
            return rows.get(0).getOcnName();
        }
        return "";
    }
    public String getFirstCategory(){
        if (rows.size()>0){
            return rows.get(0).getCategory();
        }
        return "";
    }
    public String getFirstSpid(){
        if (rows.size()>0){
            return rows.get(0).getSpid();
        }
        return "";
    }
    public String getFirstSpidName(){
        if (rows.size()>0){
            return rows.get(0).getSpidName();
        }
        return "";
    }
    public String getFirstCospecName(){
        if (rows.size()>0){
            return rows.get(0).getCoSpecName();
        }
        return "";
    }
    public String getFirstCospecOcnName(){
        if (rows.size()>0){
            return rows.get(0).getCoSpecOrOcnName();
        }
        return "";
    }
    public String getFirstSvType(){
        if (rows.size()>0){
            return rows.get(0).getSvtype();
        }
        return "";
    }
    public void clear(){
        rows.clear();
    }

    public DipReport() {
        rows=new ArrayList<rows.JSONLrn>();
        tn="";
    }

    public List<JSONLrn> getRows() {
        return rows;
    }

    public void setRows(List<JSONLrn> rows) {
        this.rows = rows;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }
    
    
}
