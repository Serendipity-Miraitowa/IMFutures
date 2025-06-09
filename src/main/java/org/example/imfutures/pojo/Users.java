package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
@Schema(name = "用户实体类")
//用户实体类
public class Users {

    @Schema(name = "用户id", description = "用户唯一标识", example = "1")
    private Integer uid;  //用户id

    @Schema(name = "用户名", description = "用户名称", example = "天天开心")
    private String userName;  //用户名

    @Schema(name = "密码", description = "用户登录密码，采用pbkdf2加密算法加密", example = "64269219b40bd94e59018e3142fc97b28603312313dc9e337958ac7a540c22ac1f2cd4beb1e4aa558dc9c91117d94bba2ea21a0504508e6b05c52e6cbe084915")
    private String password;  //密码

    @Schema(name = "盐值", description = "密码加密盐值", example = "d360496376f659882fc03d59b830279e")
    private String salt; //盐值

    @Schema(name = "手机号", description = "用户登录的手机号", example = "13056489764")
    private String phone; //手机号

    @Schema(name = "邮箱", description = "用户邮箱", example = "25616@163.com")
    private String email; //邮箱

    @Schema(name = "身份证id", description = "身份证id", example = "1562342004120312354")
    private Integer cardId; //身份证id

    @Schema(name = "头像", description = "头像(存储网络地址)", example = "https://aliyun.com/516130655/1256156")
    private String avatar; //头像(存储网络地址)

    @Schema(name = "性别", description = "用户性别", example = "男")
    private String sex; //性别

    @Schema(name = "创建时间", description = "用户信息创建时间", example = "2025-06-08")
    private Timestamp createDate; //创建时间

    @Schema(name = "更新时间", description = "用户信息更新时间", example = "2025-06-08")
    private Timestamp updateDate; //用户信息更新时间

    @Schema(name = "用户状态", description = "用户状态", example = "1")
    private Integer status;  //用户状态

    @Schema(name = "支付密码", description = "支付密码", example = "123456")
    private String payPassword; //支付密码

    @Schema(name = "出生日期", description = "出生日期", example = "2025-06-08")
    private Date birthday;  //出生日期


}
