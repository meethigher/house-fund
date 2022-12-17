package top.meethigher.house.fund.domain;

/**
 * @author https://github.com/meethigher
 * <p>
 * 单位的Javabean
 */
public class Unit {
    private String unitaccnum;
    private String unitaccname;
    private String unitaddr;
    private String orgcode;
    private String unitchar;
    private String unitkind;
    private String salarydate;
    private String unitphone;
    private String unitlinkman;
    private String unitagentpapno;
    private String accstate;
    private Double balance;
    private Double basenumber;
    private Double unitprop;
    private Double perprop;
    private Double unitpaysum;
    private Double perpaysum;
    private String persnum;
    private String lastpaydate;
    private String instcode;
    private String op;
    private String createdate;
    private String remark;

    public String getUnitaccnum() {
        return unitaccnum;
    }

    public void setUnitaccnum(String unitaccnum) {
        this.unitaccnum = unitaccnum;
    }

    public String getUnitaccname() {
        return unitaccname;
    }

    public void setUnitaccname(String unitaccname) {
        this.unitaccname = unitaccname;
    }

    public String getUnitaddr() {
        return unitaddr;
    }

    public void setUnitaddr(String unitaddr) {
        this.unitaddr = unitaddr;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getUnitchar() {
        return unitchar;
    }

    public void setUnitchar(String unitchar) {
        this.unitchar = unitchar;
    }

    public String getUnitkind() {
        return unitkind;
    }

    public void setUnitkind(String unitkind) {
        this.unitkind = unitkind;
    }

    public String getSalarydate() {
        return salarydate;
    }

    public void setSalarydate(String salarydate) {
        this.salarydate = salarydate;
    }

    public String getUnitphone() {
        return unitphone;
    }

    public void setUnitphone(String unitphone) {
        this.unitphone = unitphone;
    }

    public String getUnitlinkman() {
        return unitlinkman;
    }

    public void setUnitlinkman(String unitlinkman) {
        this.unitlinkman = unitlinkman;
    }

    public String getUnitagentpapno() {
        return unitagentpapno;
    }

    public void setUnitagentpapno(String unitagentpapno) {
        this.unitagentpapno = unitagentpapno;
    }

    public String getAccstate() {
        return accstate;
    }

    public void setAccstate(String accstate) {
        this.accstate = accstate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public Double getUnitpaysum() {
        return unitpaysum;
    }

    public void setUnitpaysum(Double unitpaysum) {
        this.unitpaysum = unitpaysum;
    }

    public Double getPerpaysum() {
        return perpaysum;
    }

    public void setPerpaysum(Double perpaysum) {
        this.perpaysum = perpaysum;
    }

    public String getPersnum() {
        return persnum;
    }

    public void setPersnum(String persnum) {
        this.persnum = persnum;
    }

    public String getLastpaydate() {
        return lastpaydate;
    }

    public void setLastpaydate(String lastpaydate) {
        this.lastpaydate = lastpaydate;
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

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitaccnum='" + unitaccnum + '\'' +
                ", unitaccname='" + unitaccname + '\'' +
                ", unitaddr='" + unitaddr + '\'' +
                ", orgcode='" + orgcode + '\'' +
                ", unitchar='" + unitchar + '\'' +
                ", unitkind='" + unitkind + '\'' +
                ", salarydate='" + salarydate + '\'' +
                ", unitphone='" + unitphone + '\'' +
                ", unitlinkman='" + unitlinkman + '\'' +
                ", unitagentpapno='" + unitagentpapno + '\'' +
                ", accstate='" + accstate + '\'' +
                ", balance=" + balance +
                ", basenumber=" + basenumber +
                ", unitprop=" + unitprop +
                ", perprop=" + perprop +
                ", unitpaysum=" + unitpaysum +
                ", perpaysum=" + perpaysum +
                ", persnum='" + persnum + '\'' +
                ", lastpaydate='" + lastpaydate + '\'' +
                ", instcode='" + instcode + '\'' +
                ", op='" + op + '\'' +
                ", createdate='" + createdate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
