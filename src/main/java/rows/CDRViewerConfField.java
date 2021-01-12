
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class CDRViewerConfField {
    private String fieldName;
    private String Type;
    private String dispName;
    private int pos;

    public CDRViewerConfField(String FieldName, String Type, String DispName) {
        this.fieldName = FieldName;
        this.Type = Type;
        this.dispName = DispName;
    
    }

  
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

   
    
}
