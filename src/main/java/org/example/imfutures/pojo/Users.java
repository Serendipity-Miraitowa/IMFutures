package org.example.imfutures.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
//用户实体类
public class Users {
    private Integer uid;  //用户id
    private String userName;  //用户名
    private String password;  //密码
    private String salt; //盐值
    private String phone; //手机号
    private String email; //邮箱
    private Integer cardId; //身份证id
    private String avatar; //头像(存储网络地址)
    private String sex; //性别
    private Timestamp createDate; //创建时间
    private Timestamp updateDate; //用户信息更新时间
    private Integer status;  //用户状态
    private String payPassword; //支付密码
    private Date birthday;  //出生日期

    public Users() {
    }

    public Users(Integer uid, String userName, String password, String salt, String phone, String email, Integer cardId, String avatar, String sex, Timestamp createDate, Timestamp updateDate, Integer status, String payPassword, Date birthday) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.email = email;
        this.cardId = cardId;
        this.avatar = avatar;
        this.sex = sex;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.payPassword = payPassword;
        this.birthday = birthday;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cardId=" + cardId +
                ", avatar='" + avatar + '\'' +
                ", sex='" + sex + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                ", payPassword='" + payPassword + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
