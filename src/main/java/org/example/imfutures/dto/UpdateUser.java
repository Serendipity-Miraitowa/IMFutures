package org.example.imfutures.dto;


import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class UpdateUser {
    private Integer id;
    private String password;
    private String userName;
    private String sex;
    private String birthday;
    private String phone;
    private String email;
    private String avatar;
    private String salt;


    public UpdateUser() {
    }

    public UpdateUser(Integer id, @Nullable String password, @Nullable String userName, @Nullable String sex, @Nullable String birthday, @Nullable String phone, @Nullable String email, @Nullable String avatar, @Nullable String salt) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
