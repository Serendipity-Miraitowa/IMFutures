package org.example.imfutures.dto.loginAndRegister;


import lombok.Data;

@Data
public class Register {
    private Integer uid;
    private String phone; //手机号
    private String password; //密码
    private String salt; //盐值
    private String userName; //用户名
    private String email; //邮箱
    private String avatar; //头像(存储网络地址)
    private String sex; //性别
    private Integer status;  //用户状态

    public Register() {
    }

    public Register(Integer uid, String phone, String password, String salt, String userName, String email, String avatar, String sex, Integer status) {
        this.uid = uid;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.userName = userName;
        this.email = email;
        this.avatar = avatar;
        this.sex = sex;
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
