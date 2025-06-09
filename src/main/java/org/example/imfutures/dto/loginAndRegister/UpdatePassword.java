package org.example.imfutures.dto.loginAndRegister;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Schema(name = "忘记密码实体")
public class UpdatePassword {
    @Schema(name = "手机号", description = "用户登录的手机号", example = "13056489764")
    private String phone; //手机号
    @Schema(name = "密码", description = "用户登录密码，采用pbkdf2加密算法加密", example = "64269219b40bd94e59018e3142fc97b28603312313dc9e337958ac7a540c22ac1f2cd4beb1e4aa558dc9c91117d94bba2ea21a0504508e6b05c52e6cbe084915")
    private String password; //密码
    @Schema(name = "盐值", description = "密码加密盐值", example = "d360496376f659882fc03d59b830279e")
    private String salt; //盐值
    @Schema(name = "更新时间", description = "用户信息更新时间", example = "2025-06-08")
    private Timestamp updateDate; //更新时间

}
