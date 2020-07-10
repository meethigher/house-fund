package domain;

/**
 * @author https://github.com/meethigher
 * <p>
 * 用于控制公积金账号的javabean
 */
public class AccNumControl {
    private String seqname;
    private int seq;
    private int maxseq;
    private String desc;
    private String freeuse;

    public String getSeqname() {
        return seqname;
    }

    public void setSeqname(String seqname) {
        this.seqname = seqname;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getMaxseq() {
        return maxseq;
    }

    public void setMaxseq(int maxseq) {
        this.maxseq = maxseq;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFreeuse() {
        return freeuse;
    }

    public void setFreeuse(String freeuse) {
        this.freeuse = freeuse;
    }
}
