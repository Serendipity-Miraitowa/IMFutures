package org.example.imfutures.service;


import org.example.imfutures.dto.PayList;
import org.example.imfutures.pojo.Pay;

import java.util.List;

public interface PayService {

    /**
     * 查询支付账单
     * @param uid
     * @return
     */
    List<Pay> selectPay(Integer uid);

    /**
     *查询支付账单根据预定订单
     * @param uid
     * @return
     */
    List<Pay> select(Integer uid);

    /**
     *删除支付账单
     * @param uid
     */
    void delete(Integer uid);

    /**
     *查询支付账单详情
     * @param id
     * @return
     */
    Pay selectDetail(Integer id);

    /**
     * 添加支付订单
     * @param pay
     */
    boolean addPay(Pay pay);

    /**
     * 查询支付方式
     * @param uid
     * @return
     */
    List<String> payWayList(Integer uid);

    /**
     *根据用户id和充电站id查询充电订单
     * @param payList
     * @return
     */
    List<Pay> payList(PayList payList);
    
}
