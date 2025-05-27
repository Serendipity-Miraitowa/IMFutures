package org.example.imfutures.service;

import com.huaweicloud.sdk.iotda.v5.model.CreateCommandResponse;
import com.huaweicloud.sdk.iotda.v5.model.ListPropertiesResponse;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.CommandDevice;
import org.example.imfutures.dto.InsertCar;
import org.example.imfutures.dto.Properties;
import org.example.imfutures.pojo.Car;

import java.util.List;

public interface CarService {
    /**
     * 查询车辆详细信息
     * @param id
     * @return
     */
    List<Car> selectCar(Integer id);


    /**
     *添加车辆
     * @param car
     */
    void insertCar(InsertCar car);

    /**
     * 删除车辆信息
     * @param ids
     * @param deviceIds
     */
    void deleteCar(Integer[] ids, String[] deviceIds);

    /**
     * 查询车辆是否存在
     * @param frameNumber  车架号
     * @return
     */
    Boolean selectCarIsHaving(String frameNumber);

    /**
     * 查询设备基础属性
     * @param serviceId  服务id
     * @param deviceId  设备id
     * @return
     */
    Properties listProperties(String serviceId, String deviceId);

    /**
     * 查询设备检查属性
     * @param serviceId
     * @param deviceId
     * @return
     */
    CheckProperties checkProperties(String serviceId, String deviceId);

    /**
     * 控制设备命令参数
     * @param device
     * @return
     */
    Boolean commandDevice(CommandDevice device);

    /**
     * 查询连接参数
     * @param frameNumber
     * @return
     */
    Car selectConnect(String frameNumber);
}
