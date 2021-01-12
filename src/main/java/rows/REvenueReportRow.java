package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class REvenueReportRow {
    //Header: Outbound Trunk,Routing Type,Attempts,Answered,ASR,ALOC,Rate Per Min,Revenue
    private String OutboundTrunk;
    private String RoutingType;
    private Integer Attempts;
    private Integer Answered;
    private Double ASR;
    private Integer Aloc;
    private Double RatePerMin;
    private Double Rewenue;
    private Double Minutes;

    public REvenueReportRow(String OutboundTrunk, String RoutingType, Integer Attempts, Integer Answered, Double ASR, Integer Aloc, Double RatePerMin, Double Rewenue, Double Minutes) {
        this.OutboundTrunk = OutboundTrunk;
        this.RoutingType = RoutingType;
        this.Attempts = Attempts;
        this.Answered = Answered;
        this.ASR = ASR;
        this.Aloc = Aloc;
        this.RatePerMin = RatePerMin;
        this.Rewenue = Rewenue;
        this.Minutes = Minutes;
    }

    

    public REvenueReportRow() {
        this.OutboundTrunk = "";
        this.RoutingType = "";
        this.Attempts = 0;
        this.Answered = 0;
        this.ASR = 0.0;
        this.Aloc = 0;
        this.RatePerMin = 0.0;
        this.Rewenue = 0.0;
        this.Minutes=0.0;
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

    public Integer getAttempts() {
        return Attempts;
    }

    public void setAttempts(Integer Attempts) {
        this.Attempts = Attempts;
    }

    public Integer getAnswered() {
        return Answered;
    }

    public void setAnswered(Integer Answered) {
        this.Answered = Answered;
    }

    public Integer getAloc() {
        return Aloc;
    }

    public void setAloc(Integer Aloc) {
        this.Aloc = Aloc;
    }

    public String getASR() {
        return String.format("%.1f", ASR);
    }

    public void setASR(Double ASR) {
        this.ASR = ASR;
    }

    public Double getRatePerMin() {
        return RatePerMin;
    }

    public void setRatePerMin(Double RatePerMin) {
        this.RatePerMin = RatePerMin;
    }

    public String getRewenue() {
        return String.format("%.2f", Rewenue);
    }

    public void setRewenue(Double Rewenue) {
        this.Rewenue = Rewenue;
    }

    public long getMinutes() {
        return (long)(Minutes.longValue()/60);
    }

    public void setMinutes(Double Minutes) {
        this.Minutes = Minutes;
    }
    
   
}
