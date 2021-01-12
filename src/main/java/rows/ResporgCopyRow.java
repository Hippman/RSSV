package rows;

/**
 *
 * @author Valeriy Surjenko.
 */
public class ResporgCopyRow {
    private String resporg;
    private String name;
    private Long cnt;

    public ResporgCopyRow(String resporg, String name, Long cnt) {
        this.resporg = resporg;
        this.cnt = cnt;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getResporg() {
        return resporg;
    }

    public void setResporg(String resporg) {
        this.resporg = resporg;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }
    
}
