
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class IpStats2Row {
    private String date;
    private Integer value;

    public IpStats2Row(String date, Integer value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
}
