package org.example.imfutures.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.imfutures.dto.Cards;
import org.example.imfutures.dto.UpdateUser;
import org.example.imfutures.pojo.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(UpdateUser user);

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
    void addCard(Card card);

    /**
     * 更新用户表实名信息
     * @param map
     */
    void update(HashMap<String, Integer> map);

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
    @Select("select card_id from users where uid = #{id}")
    Integer selectCardId(Integer id);
    @Select("select * from card where id = #{id}")
    Card selectCard(Integer id);


    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Select("select uid, user_name, phone, card_id, email, avatar, sex, birthday from users where uid = #{id}")
    Users selectUserInfo(Integer id);


    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    @Select("select * from nav where user_id = #{uid}")
    List<Nav> selectNav(Integer uid);

    /**
     * 删除历史导航
     * @param uid
     */
    @Delete("delete from nav where user_id = #{uid}")
    void deleteNav(Integer uid);

    /**
     * 修改支付密码
     * @param users
     */
    void updatePayPassword(Users users);

    /**
     * 查询免密支付列表
     * @param uid
     * @return
     */
    List<FreePay> selectNoPay(Integer uid);

    /**
     * 查询免密支付详情
     * @param id
     * @return
     */
    FreePay selectNoPayDetail(Integer id);


}
