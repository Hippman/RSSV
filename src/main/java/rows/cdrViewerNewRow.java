package rows;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Valeriy Surjenko.
 */
public class cdrViewerNewRow {
    private HashMap<String,String> fields;

    public cdrViewerNewRow() {
        fields=new HashMap<>();
    }

    public HashMap<String,String> getFields() {
        return fields;
    }

    public void setFields(HashMap<String,String> fields) {
        this.fields = fields;
    }
    public String getVal(String colName){
        if (fields.containsKey(colName)){
            return fields.get(colName);
        }
        return "";
    }
    
}
