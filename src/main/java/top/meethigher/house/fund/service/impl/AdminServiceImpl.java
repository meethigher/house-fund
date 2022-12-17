package top.meethigher.house.fund.service.impl;

import top.meethigher.house.fund.dao.AdminDao;
import top.meethigher.house.fund.dao.impl.AdminDaoImpl;
import top.meethigher.house.fund.domain.Admin;
import top.meethigher.house.fund.service.AdminService;

/**
 * @author https://github.com/meethigher
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return dao.findAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword());
    }

    @Override
    public Admin findByUsername(String username) {
        return dao.findAdminByUsername(username);
    }

    @Override
    public int update(Admin admin) {
        return dao.update(admin);
    }
}
