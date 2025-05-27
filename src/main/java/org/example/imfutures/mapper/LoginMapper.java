package org.example.imfutures.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.imfutures.dto.loginAndRegister.Login;
import org.example.imfutures.dto.loginAndRegister.Register;
import org.example.imfutures.dto.loginAndRegister.UpdatePassword;
import org.example.imfutures.pojo.Users;

@Mapper
public interface LoginMapper {

    /**
     * 注册
     * @param register
     */
    void register(Register register);

    /**
     *查询是否有账号
     * @param login
     * @return
     */
    Long isHaveAccount(Login login);

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
    void updatePassword(UpdatePassword updatePassword);

}
