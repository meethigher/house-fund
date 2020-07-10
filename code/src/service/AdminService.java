package service;

import domain.Admin;

/**
 * @author https://github.com/meethigher
 * <p>
 * 管理员的业务接口
 */
public interface AdminService {
    /**
     * 登录
     *
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /**
     * 通过名称查询所有数据
     *
     * @param username
     * @return
     */
    Admin findByUsername(String username);

    /**
     * 更新密码
     *
     * @param admin
     * @return
     */
    int update(Admin admin);
}
