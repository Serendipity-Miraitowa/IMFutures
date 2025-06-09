package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//支付方式
@Data
@Schema(name = "支付方式实体")
public class UserPayWay {

    @Schema(name = "支付方式id", description = "支付方式唯一标识", example = "1")
    private Integer id;

    @Schema(name = "用户id", description = "用户关联id", example = "1")
    private Integer userId; //用户id

    @Schema(name = "银行卡类型", description = "银行卡类型", example = "储蓄卡")
    private String type;  //银行卡类型

    @Schema(name = "支付方式名称", description = "支付方式名称", example = "微信支付")
    private String name; //支付方式名称

    @Schema(name = "支付方式号码", description = "支付方式号码", example = "4859564165")
    private String number; //支付方式号码

    @Schema(name = "支付顺序", description = "支付方式顺序", example = "1")
    private int sequence; //支付顺序

}
