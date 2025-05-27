package org.example.imfutures.service;

import org.example.imfutures.dto.Cards;
import org.example.imfutures.dto.UpdateUser;
import org.example.imfutures.pojo.*;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    /**
     * 更新用户信息
     * @param user
     */
    Users updateUser(UpdateUser user);


    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Users select(Integer id);

    /**
     * 添加身份认证信息
     * @param card
     */
    void addCard(Cards card);

    /**
     * 更新实名认证
     * @param card
     */
    void updateCard(Cards card);

    /**
     * 查询身份信息
     * @param id
     * @return
     */
    Card selectCard(Integer id);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Users selectUserInfo(Integer id);

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    List<Nav> selectNav(Integer uid);

    /**
     * 删除历史导航
     * @param uid
     */
    void deleteNav(Integer uid);

    /**
     * 修改支付密码
     * @param users
     */
    void updatePayPassword(Users users);

    /**
     * 查询免密支付详情
     * @param id
     * @return
     */
    FreePay selectNoPayDetail(Integer id);

    /**
     * 查询免密支付
     * @param uid
     * @return
     */
    List<FreePay> selectNoPayList(Integer uid);
}
