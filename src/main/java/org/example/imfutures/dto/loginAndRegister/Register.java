package org.example.imfutures.dto.loginAndRegister;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户注册实体")
public class Register {

    @Schema(name = "用户id", description = "用户唯一标识", example = "1")
    private Integer uid;

    @Schema(name = "手机号", description = "用户登录的手机号", example = "13056489764")
    private String phone; //手机号

    @Schema(name = "密码", description = "用户登录密码，采用pbkdf2加密算法加密", example = "64269219b40bd94e59018e3142fc97b28603312313dc9e337958ac7a540c22ac1f2cd4beb1e4aa558dc9c91117d94bba2ea21a0504508e6b05c52e6cbe084915")
    private String password; //密码

    @Schema(name = "盐值", description = "密码加密盐值", example = "d360496376f659882fc03d59b830279e")
    private String salt; //盐值

    @Schema(name = "用户名", description = "用户名称", example = "天天开心")
    private String userName; //用户名

    @Schema(name = "邮箱", description = "用户邮箱", example = "25616@163.com")
    private String email; //邮箱

    @Schema(name = "头像", description = "头像(存储网络地址)", example = "https://aliyun.com/516130655/1256156")
    private String avatar; //头像(存储网络地址)

    @Schema(name = "性别", description = "用户性别", example = "男")
    private String sex; //性别

    @Schema(name = "用户状态", description = "用户登录状态，用于控制多端登录", example = "1")
    private Integer status;  //用户状态
}
