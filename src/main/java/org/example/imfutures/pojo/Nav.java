package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/*导航历史实体类*/
@Data
@Schema(name = "导航历史实体类")
public class Nav {

    @Schema(name = "导航历史id", description = "导航历史唯一标识", example = "1")
    private Integer id;

    @Schema(name = "用户id", description = "用户关联id", example = "1")
    private Integer userId; //用户id

    @Schema(name = "地址", description = "导航地址", example = "关山大道")
    private String address; //地址

    @Schema(name = "预定日期", description = "订单的预定日期", example = "2025-06-10")
    private Date date; //导航日期


}
