package org.example.imfutures.service.Impl;


import org.example.imfutures.dto.loginAndRegister.Login;
import org.example.imfutures.dto.loginAndRegister.Register;
import org.example.imfutures.dto.loginAndRegister.UpdatePassword;
import org.example.imfutures.mapper.LoginMapper;
import org.example.imfutures.mapper.MessageMapper;
import org.example.imfutures.pojo.Message;
import org.example.imfutures.pojo.Users;
import org.example.imfutures.service.LoginService;
import org.example.imfutures.utils.PBKDF2Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper mapper;
    @Autowired
    MessageMapper messageMapper;

    PBKDF2Util pbkdf2Util = new PBKDF2Util();

    /**
     * 注册
     * @param reg
     */
    @Override
    @Transactional
    public void register(Login reg) {
        String password = reg.getPassword();
        Register register = new Register();
        BeanUtils.copyProperties(reg, register);
        try {
            String salt = pbkdf2Util.generateSalt(); //获取盐值
            String newPassword = pbkdf2Util.getEncryptedPassword(password, salt); //获取加密密码
            register.setPassword(newPassword);
            register.setSalt(salt);
            register.setStatus(0);
            if (register.getUserName() == null){
                register.setUserName("天天开心");
            }
            if (register.getSex() == null){
                register.setSex("男");
            }
            if (register.getAvatar() == null){
                register.setAvatar("avatar.png");
            }
            mapper.register(register);
            //添加注册成功消息
            Message message = new Message();
            message.setUserId(register.getUid());
            message.setContent("欢迎您加入智行未来，希望您使用愉快");
            message.setTitle("系统通知");
            message.setStatus(1);
            message.setDate(new Date());
            messageMapper.insertMessage(message);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询是否有账号
     * @param login
     * @return
     */
    @Override
    public boolean isHaveAccount(Login login) {
        Long l = mapper.isHaveAccount(login);
        return l != null;
    }

    /**
     * 比较密码是否正确
     * @param login
     * @return
     */
    @Override
    public Users isTrue(Login login) {
        String passwords = login.getPassword();
        Users users = mapper.isTrue(login);
        String password = users.getPassword();
        String salt = users.getSalt();
        try {
            boolean isTrue = pbkdf2Util.authenticate(passwords, password, salt);
            if (isTrue){
                return users;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Users login(Login login) {
        return mapper.login(login);
    }

    /**
     * 修改登录密码
     * @param update
     */
    @Override
    public void updatePassword(Login update) {
        String password = update.getPassword();
        UpdatePassword updatePassword = new UpdatePassword();
        BeanUtils.copyProperties(update, updatePassword);
        try {
            String salt = pbkdf2Util.generateSalt(); //获取盐值
            String newPassword = pbkdf2Util.getEncryptedPassword(password, salt); //获取加密密码
            updatePassword.setPassword(newPassword);
            updatePassword.setSalt(salt);
            updatePassword.setUpdateDate(new Timestamp(new Date().getTime()));
            mapper.updatePassword(updatePassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
