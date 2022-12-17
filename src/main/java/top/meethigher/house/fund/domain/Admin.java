package top.meethigher.house.fund.domain;

/**
 * @author https://github.com/meethigher
 * <p>
 * 管理员的javabean
 */
public class Admin {
    private String username;
    private String password;
    private String addr;
    private String lasttime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                ", lasttime='" + lasttime + '\'' +
                '}';
    }
}
