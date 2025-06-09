package org.example.imfutures.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "身份证信息实体类")
//身份证信息实体类
public class Cards {

    @Schema(name = "身份证id", description = "身份证唯一标识", example = "1")
    private Integer id;

    @Schema(name = "姓名", description = "用户真实姓名", example = "余念安")
    private String name; //姓名

    @Schema(name = "身份证号码", description = "身份证号码", example = "246135200410265461")
    private String number; //身份证号码

    @Schema(name = "身份证有效期开始日期", description = "身份证有效期开始日期", example = "2025-03-03")
    private Date startDay; //身份证有效期开始日期

    @Schema(name = "身份证有效期结束日期", description = "身份证有效期结束日期", example = "2035-03-03")
    private Date endDay; //身份证有效期结束日期

    @Schema(name = "性别", description = "用户真实性别", example = "男")
    private String sex; //性别

    @Schema(name = "身份证类型", description = "身份证类型", example = "居民身份证")
    private String type; //身份证类型

    @Schema(name = "国籍", description = "国籍", example = "中国")
    private String nationality;  //国籍

    @Schema(name = "出生日期", description = "出生日期", example = "2004-10-26")
    private Date birthday;  //出生日期

    @Schema(name = "用户id", description = "关联的用户id", example = "1")
    private Integer uid; //用户id

}
