package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import service.AdminService;

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
