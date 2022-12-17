package top.meethigher.house.fund.domain;

/**
 * @author https://github.com/meethigher
 * <p>
 * 个人的javabean
 */
public class Person {
    private String accnum;
    private String accname;
    private String papno;
    private String unitaccnum;
    private String opendate;
    private Double balance;
    private String peraccstate;
    private Double basenumber;
    private Double unitprop;
    private Double perprop;
    private String lastpaydate;
    private Double unitmonpaysum;
    private Double permonpaysum;
    private Double ypayamt;
    private Double ydrawamt;
    private Double yinterestbal;
    private String instcode;
    private String op;
    private String remark;

    //实现person与unit的一对一关系
//    private Unit unit;
    private String unitaccname;

    public String getUnitaccname() {
        return unitaccname;
    }

    public void setUnitaccname(String unitaccname) {
        this.unitaccname = unitaccname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "accnum='" + accnum + '\'' +
                ", accname='" + accname + '\'' +
                ", papno='" + papno + '\'' +
                ", unitaccnum='" + unitaccnum + '\'' +
                ", opendate=" + opendate +
                ", balance=" + balance +
                ", peraccstate='" + peraccstate + '\'' +
                ", basenumber=" + basenumber +
                ", unitprop=" + unitprop +
                ", perprop=" + perprop +
                ", lastpaydate=" + lastpaydate +
                ", unitmonpaysum=" + unitmonpaysum +
                ", permonpaysum=" + permonpaysum +
                ", ypayamt=" + ypayamt +
                ", ydrawamt=" + ydrawamt +
                ", yinterestbal=" + yinterestbal +
                ", instcode='" + instcode + '\'' +
                ", op='" + op + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getAccnum() {
        return accnum;
    }

    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public String getPapno() {
        return papno;
    }

    public void setPapno(String papno) {
        this.papno = papno;
    }

    public String getUnitaccnum() {
        return unitaccnum;
    }

    public void setUnitaccnum(String unitaccnum) {
        this.unitaccnum = unitaccnum;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPeraccstate() {
        return peraccstate;
    }

    public void setPeraccstate(String peraccstate) {
        this.peraccstate = peraccstate;
    }

    public Double getBasenumber() {
        return basenumber;
    }

    public void setBasenumber(Double basenumber) {
        this.basenumber = basenumber;
    }

    public Double getUnitprop() {
        return unitprop;
    }

    public void setUnitprop(Double unitprop) {
        this.unitprop = unitprop;
    }

    public Double getPerprop() {
        return perprop;
    }

    public void setPerprop(Double perprop) {
        this.perprop = perprop;
    }

    public String getLastpaydate() {
        return lastpaydate;
    }

    public void setLastpaydate(String lastpaydate) {
        this.lastpaydate = lastpaydate;
    }

    public Double getUnitmonpaysum() {
        return unitmonpaysum;
    }

    public void setUnitmonpaysum(Double unitmonpaysum) {
        this.unitmonpaysum = unitmonpaysum;
    }

    public Double getPermonpaysum() {
        return permonpaysum;
    }

    public void setPermonpaysum(Double permonpaysum) {
        this.permonpaysum = permonpaysum;
    }

    public Double getYpayamt() {
        return ypayamt;
    }

    public void setYpayamt(Double ypayamt) {
        this.ypayamt = ypayamt;
    }

    public Double getYdrawamt() {
        return ydrawamt;
    }

    public void setYdrawamt(Double ydrawamt) {
        this.ydrawamt = ydrawamt;
    }

    public Double getYinterestbal() {
        return yinterestbal;
    }

    public void setYinterestbal(Double yinterestbal) {
        this.yinterestbal = yinterestbal;
    }

    public String getInstcode() {
        return instcode;
    }

    public void setInstcode(String instcode) {
        this.instcode = instcode;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
