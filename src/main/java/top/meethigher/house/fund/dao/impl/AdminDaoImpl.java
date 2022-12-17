package top.meethigher.house.fund.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.meethigher.house.fund.dao.AdminDao;
import top.meethigher.house.fund.domain.Admin;
import top.meethigher.house.fund.util.JDBCUtils;

/**
 * @author https://github.com/meethigher
 */
public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin findAdminByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from tb004 where username = ? and password = ?";
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username, password);
            return admin;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Admin findAdminByUsername(String username) {
        try {
            String sql = "select * from tb004 where username = ?";
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username);
            return admin;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int update(Admin admin) {
        try {
            String sql = "update tb004 set username=?,password=?,addr=?,lasttime=? where username=?";
            int count = template.update(sql, admin.getUsername(), admin.getPassword(), admin.getAddr(), admin.getLasttime(), admin.getUsername());
            return count;
        } catch (Exception e) {
            return 0;
        }
    }
}
