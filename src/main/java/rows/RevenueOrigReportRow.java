
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class RevenueOrigReportRow {
    private String OutboundTrunk;
    private String RoutingType;
    private Integer R2Attempts;
    private Integer R2Answered;
    private Double R2ASR;
    private Integer R2Alloc;
    private Double R2RatePerMin;
    private Double R2Revenue;
    private Double R2Minutes;
    
    private Integer BtAttempts;
    private Integer BtAnswered;
    private Double BtASR;
    private Integer BtAlloc;
    private Double BtRatePerMin;
    private Double BtRevenue;
    private Double BtMinutes;

    public RevenueOrigReportRow(String OutboundTrunk, String RoutingType, Integer R2Attempts, Integer R2Answered, Double R2ASR, Integer R2Alloc, Double R2RatePerMin, Double R2Revenue, Double R2Minutes, Integer BtAttempts, Integer BtAnswered, Double BtASR, Integer BtAlloc, Double BtRatePerMin, Double BtRevenue, Double BtMinutes) {
        this.OutboundTrunk = OutboundTrunk;
        this.RoutingType = RoutingType;
        this.R2Attempts = R2Attempts;
        this.R2Answered = R2Answered;
        this.R2ASR = R2ASR;
        this.R2Alloc = R2Alloc;
        this.R2RatePerMin = R2RatePerMin;
        this.R2Revenue = R2Revenue;
        this.R2Minutes = R2Minutes;
        this.BtAttempts = BtAttempts;
        this.BtAnswered = BtAnswered;
        this.BtASR = BtASR;
        this.BtAlloc = BtAlloc;
        this.BtRatePerMin = BtRatePerMin;
        this.BtRevenue = BtRevenue;
        this.BtMinutes = BtMinutes;
    }

    

    public String getOutboundTrunk() {
        return OutboundTrunk;
    }

    public void setOutboundTrunk(String OutboundTrunk) {
        this.OutboundTrunk = OutboundTrunk;
    }

    public String getRoutingType() {
        return RoutingType;
    }

    public void setRoutingType(String RoutingType) {
        this.RoutingType = RoutingType;
    }

    public Integer getR2Attempts() {
        return R2Attempts;
    }

    public void setR2Attempts(Integer R2Attempts) {
        this.R2Attempts = R2Attempts;
    }

    public Integer getR2Answered() {
        return R2Answered;
    }

    public void setR2Answered(Integer R2Answered) {
        this.R2Answered = R2Answered;
    }

    public String getR2ASR() {
        return String.format("%.1f",R2ASR);
    }

    public void setR2ASR(Double R2ASR) {
        this.R2ASR = R2ASR;
    }

    public Integer getR2Alloc() {
        return R2Alloc;
    }

    public void setR2Alloc(Integer R2Alloc) {
        this.R2Alloc = R2Alloc;
    }

    public Double getR2RatePerMin() {
        return R2RatePerMin;
    }

    public void setR2RatePerMin(Double R2RatePerMin) {
        this.R2RatePerMin = R2RatePerMin;
    }

    public String getR2Revenue() {
        return String.format("%.2f",R2Revenue);
    }

    public void setR2Revenue(Double R2Revenue) {
        this.R2Revenue = R2Revenue;
    }

    public Integer getBtAttempts() {
        return BtAttempts;
    }

    public void setBtAttempts(Integer BtAttempts) {
        this.BtAttempts = BtAttempts;
    }

    public Integer getBtAnswered() {
        return BtAnswered;
    }

    public void setBtAnswered(Integer BtAnswered) {
        this.BtAnswered = BtAnswered;
    }

    public String getBtASR() {
        return String.format("%.1f",BtASR);
    }

    public void setBtASR(Double BtASR) {
        this.BtASR = BtASR;
    }

    public Integer getBtAlloc() {
        return BtAlloc;
    }

    public void setBtAlloc(Integer BtAlloc) {
        this.BtAlloc = BtAlloc;
    }

    public Double getBtRatePerMin() {
        return BtRatePerMin;
    }

    public void setBtRatePerMin(Double BtRatePerMin) {
        this.BtRatePerMin = BtRatePerMin;
    }

    public String getBtRevenue() {
        return String.format("%.2f",BtRevenue);
    }

    public void setBtRevenue(Double BtRevenue) {
        this.BtRevenue = BtRevenue;
    }

    public long getR2Minutes() {
        return R2Minutes.longValue();
    }

    public void setR2Minutes(Double R2Minutes) {
        this.R2Minutes = R2Minutes;
    }

    public long getBtMinutes() {
        return BtMinutes.longValue();
    }

    public void setBtMinutes(Double BtMinutes) {
        this.BtMinutes = BtMinutes;
    }
    
    
}
