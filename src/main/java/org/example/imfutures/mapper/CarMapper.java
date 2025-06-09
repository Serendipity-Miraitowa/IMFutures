package org.example.imfutures.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.imfutures.dto.InsertCar;
import org.example.imfutures.pojo.Car;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CarMapper {

    /**
     * 查询车辆详细信息
     * @param uid
     * @return
     */
    List<Car> selectCar(Integer uid);


    /**
     *添加车辆
     * @param car
     */
    void insertCar(Car car);
    //第二种方法
    void updateUserId(InsertCar car);

    /**
     * 删除车辆信息
     * @param id
     */
    void deleteCar(Integer id);

    /**
     * 查询车辆是否存在
     * @param frameNumber
     * @return
     */
    Boolean selectCarIsHaving(String frameNumber);

    /**
     * 查询链接参数
     * @param frameNumber
     */
    Car selectConnect(String frameNumber);
}
