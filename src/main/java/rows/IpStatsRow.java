package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class IpStatsRow {
    private String ip;
    private Integer bytes;

    public IpStatsRow(String ip, Integer bytes) {
        this.ip = ip;
        this.bytes = bytes;
    }
    public IpStatsRow(String ip, String port, Integer bytes) {
        this.ip = ip+":"+port;
        this.bytes = bytes;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }
    
    
}
