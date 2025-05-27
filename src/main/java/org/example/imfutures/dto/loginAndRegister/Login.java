package org.example.imfutures.dto.loginAndRegister;


import lombok.Data;

@Data
public class Login {
    private String phone; //手机号
    private String password; //密码

    public Login() {
    }

    public Login(String phone, String password) {
        this.phone = phone;
        this.password = password;
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
}
