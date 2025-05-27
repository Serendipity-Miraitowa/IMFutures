package org.example.imfutures.controller;


import com.huaweicloud.sdk.iotda.v5.model.ListPropertiesResponse;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.CommandDevice;
import org.example.imfutures.dto.InsertCar;
import org.example.imfutures.dto.Properties;
import org.example.imfutures.pojo.Car;
import org.example.imfutures.service.CarService;
import org.example.imfutures.utils.Callback;
import org.example.imfutures.utils.MQTTConnectUtils;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/IMFuture/car")
public class CarController {

    @Autowired
    CarService service;

    //服务id
    private static final String serviceId = "Base";
    private static final String serviceId2 = "Check";

    /**
     * 查询车辆信息
     *
     * @param uid
     * @return
     */
    @GetMapping("/selectCar")
    public Result selectCar(@RequestParam(value = "uid") Integer uid) {
        List<Car> list;
        try {
            list = service.selectCar(uid);
            if (list.size() > 0) {
                MQTTConnectUtils connectUtils = new MQTTConnectUtils();
                Car car1 = list.get(0);
                Car car = service.selectConnect(car1.getFrameNumber());
                connectUtils.connect(car.getClientId(), car.getPassword(), car.getFrameNumber(), new Callback());
            }
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 添加车辆信息
     *
     * @param insertCar
     * @return
     */
    @PostMapping("/insertCar")
    public Result insertCar(@RequestBody InsertCar insertCar) {
        try {
            if (service.selectCarIsHaving(insertCar.getFrameNumber())) {
                MQTTConnectUtils connectUtils = new MQTTConnectUtils();
                Car car = service.selectConnect(insertCar.getFrameNumber());
                connectUtils.connect(car.getClientId(), car.getPassword(), car.getFrameNumber(), new Callback());
                return new Result(true, "连接成功");
            } else {
                service.insertCar(insertCar);
                return new Result(true, "添加成功");
            }
        } catch (Exception e) {
            return new Result(false, "添加失败", e.getMessage());
        }
    }

    /**
     * 删除车辆信息
     *
     * @param ids
     * @return
     */
    @GetMapping("/deleteCar")
    public Result deleteCar(@RequestParam("ids") Integer[] ids, @RequestParam("deviceIds") String[] deviceIds) {
        try {
            service.deleteCar(ids, deviceIds);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            System.out.println("错误信息："+e.getMessage());
            return new Result(false, "删除失败", e.getMessage());
        }
    }

    /**
     * 查询设备Base属性
     *
     * @param deviceId
     * @return
     */
    @GetMapping("/selectPropertiesBase")
    public Result selectPropertiesBase(@RequestParam(value = "deviceId") String deviceId) {
        Properties properties = new Properties();
        try {
            properties = service.listProperties(serviceId, deviceId);
            return new Result(true, "查询成功", properties);
        } catch (Exception e) {
            System.out.println(e);
            return new Result(false, "服务端错误", e.getMessage());
        }
    }

    /**
     * 查询设备Check属性
     *
     * @param deviceId
     * @return
     */
    @GetMapping("/selectPropertiesCheck")
    public Result selectPropertiesCheck(@RequestParam(value = "deviceId") String deviceId) {
        CheckProperties checkProperties = new CheckProperties();
        try {
            checkProperties = service.checkProperties(serviceId2, deviceId);
            return new Result(true, "查询成功", checkProperties);
        } catch (Exception e) {
            return new Result(false, "服务端错误", e.getMessage());
        }
    }

    /**
     * 下发控制车辆命令
     *
     * @param device
     * @return
     */
    @PostMapping("/commandDevice")
    public Result commandDevice(@RequestBody CommandDevice device) {
        Boolean isSuccess;
        System.out.println("控制层设备id为："+device.getDeviceId());
        try {
            System.out.println(device.getName());
            isSuccess = service.commandDevice(device);
            return new Result(true, "命令下发成功", isSuccess);
        } catch (Exception e) {
            return new Result(false, "服务端错误", e.getMessage());
        }
    }

}
