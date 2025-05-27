package org.example.imfutures.dto.loginAndRegister;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class UpdatePassword {
    private String phone; //手机号
    private String password; //密码
    private String salt; //盐值
    private Timestamp updateDate; //更新时间

    public UpdatePassword() {
    }

    public UpdatePassword(String phone, String password, String salt, Timestamp updateDate) {
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.updateDate = updateDate;
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

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
