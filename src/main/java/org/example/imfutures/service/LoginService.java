package org.example.imfutures.service;

import org.example.imfutures.dto.loginAndRegister.Login;
import org.example.imfutures.pojo.Users;

public interface LoginService {
    /**
     * 注册
     * @param register
     */
    void register(Login register);

    /**
     *查询是否有账号
     * @param login
     * @return
     */
    boolean isHaveAccount(Login login);

    /**
     * 查询密码
     * @param login
     * @return
     */
    Users isTrue(Login login);

    /**
     * 登录
     * @param login
     * @return
     */
    Users login(Login login);

    /**
     *修改密码
     * @param updatePassword
     */
    void updatePassword(Login updatePassword);
}
