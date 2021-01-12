
package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class StatsAralocRow {
/*
SELECT repdate,attempts,answered,answered::numeric/attempts::numeric*100,seconds/answered 
FROM public.stats_asraloc 
WHERE repdate>='$fromDate' AND repdate<='$endDate' 
ORDER BY repdate
    Header: Date,Attempts,Answered,ASR,ALOC*/
    private String Repdate;
    private int Attempts;
    private int Answered;
    private float ASR;
    private float ALOC;

    public StatsAralocRow(String Repdate, int Attempts, int Answered, float ASR, float ALOC) {
        this.Repdate = Repdate;
        this.Attempts = Attempts;
        this.Answered = Answered;
        this.ASR = ASR;
        this.ALOC = ALOC;
    }

    public String getRepdate() {
        return Repdate;
    }

    public void setRepdate(String Repdate) {
        this.Repdate = Repdate;
    }

    public int getAttempts() {
        return Attempts;
    }

    public void setAttempts(int Attempts) {
        this.Attempts = Attempts;
    }

    public int getAnswered() {
        return Answered;
    }

    public void setAnswered(int Answered) {
        this.Answered = Answered;
    }

    public String getASR() {
        return String.format("%.1f", ASR);
    }

    public void setASR(float ASR) {
        this.ASR = ASR;
    }

    public float getALOC() {
        return ALOC;
    }

    public void setALOC(float ALOC) {
        this.ALOC = ALOC;
    }
    
}
