package org.example.imfutures.service.Impl;

import org.example.imfutures.dto.OrderPay;
import org.example.imfutures.dto.PayDetail;
import org.example.imfutures.dto.PayList;
import org.example.imfutures.mapper.PayMapper;
import org.example.imfutures.pojo.Pay;
import org.example.imfutures.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    PayMapper mapper;

    /**
     * 查询支付账单
     * @param uid
     * @return
     */
    @Override
    public List<Pay> selectPay(Integer uid) {
        return mapper.selectPay(uid);
    }

    /**
     * 查询支付账单根据预定订单
     * @param uid
     * @return
     */
    @Override
    public List<Pay> select(Integer uid) {
        return mapper.select(uid);
    }

    /**
     * 删除支付账单
     * @param uid
     */
    @Override
    public void delete(Integer uid) {
        mapper.delete(uid);
    }

    /**
     * 查询支付账单详情
     * @param id
     * @return
     */
    @Override
    public Pay selectDetail(Integer id) {
        return mapper.selectDetail(id);
    }


    /**
     * 添加支付订单
     * @param pay
     */
    @Transactional
    @Override
    public boolean addPay(Pay pay) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            String time = pay.getTime();
            Date date = sdf.parse(time);
            pay.setTime(sdf.format(date));
            mapper.addPay(pay);
            mapper.updateOrder(pay.getOrderId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询支付方式
     * @param uid
     * @return
     */
    @Override
    public List<String> payWayList(Integer uid) {
        return mapper.payWayList(uid);
    }

    /**
     * 根据用户id和充电站id查询充电订单
     * @param payList
     * @return
     */
    @Override
    public List<Pay> payList(PayList payList) {
        return mapper.payList(payList);
    }
}
