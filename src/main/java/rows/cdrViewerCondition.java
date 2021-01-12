package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class cdrViewerCondition {
    private String operation;
    private String fieldName;
    private String value;
    private String type;

   
    public String getDispText(){
        String ret;
        ret=fieldName+" "+operation+" ";
        if (operation.equals("like")){
            ret+="'%"+value+"%'";
        } else {
            if (type.equals("num")){
                ret+=value;
            }else{
                ret+="'"+value+"'";
            }
        }
        return ret;
    }
    
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public cdrViewerCondition() {
    }

    
    public cdrViewerCondition(String operation, String fieldName, String value, String type) {
        this.operation = operation;
        this.fieldName = fieldName;
        this.value = value;
        this.type = type;
    }
    
}
