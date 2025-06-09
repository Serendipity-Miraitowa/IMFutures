package org.example.imfutures.pojo;

import lombok.Data;

@Data
//充电桩实体类
public class ChargingPies {
    private Integer id;
    private String name; //充电桩名称
    private String type; //充电桩类型
    private String energy; //充电桩瓦数
    private Integer status; //充电桩状态
    private Integer chargingStationId; //充电柱所属充电站id
    private String speed; //充电速度

}
