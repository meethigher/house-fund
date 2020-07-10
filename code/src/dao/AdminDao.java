package dao;

import domain.Admin;

/**
 * @author https://github.com/meethigher
 */
public interface AdminDao {
    Admin findAdminByUsernameAndPassword(String username, String password);

    Admin findAdminByUsername(String username);

    int update(Admin admin);

}

