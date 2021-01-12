package rows;

/**
 *
 * @author Valeriy Surjenko.
 */

public class ChartRow {
    private Double charge;
    private Double rate;
    private Integer total;
    private String date;

    public ChartRow(Double charge, Double rate, Integer total,String date) {
        this.charge = charge;
        this.rate = rate;
        this.total = total;
        this.date=date;
    }
    
    public String getCharge() {
        return String.format("%.6f", charge);
    }
    public Double getChargeD() {
        return charge;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getRate() {
        return String.format("%.6f", rate);
    }
    public Double getRateD() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
    
}
