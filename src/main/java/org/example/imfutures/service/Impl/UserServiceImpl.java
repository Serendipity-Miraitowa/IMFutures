package org.example.imfutures.service.Impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.imfutures.dto.Cards;
import org.example.imfutures.dto.UpdateUser;
import org.example.imfutures.mapper.UserMapper;
import org.example.imfutures.pojo.*;
import org.example.imfutures.service.UserService;
import org.example.imfutures.utils.PBKDF2Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;
    PBKDF2Util pbkdf2Util = new PBKDF2Util();

    /**
     * 修改用户信息，并获取最新信息
     * @param user
     */
    @Override
    public Users updateUser(UpdateUser user) {
        String password = user.getPassword();
        System.out.println(password);
        Users users = new Users();
        try {
            if (password != null){
                System.out.println(password);
                String salt = pbkdf2Util.generateSalt();
                String newPassword = pbkdf2Util.getEncryptedPassword(password, salt);
                user.setSalt(salt);
                user.setPassword(newPassword);
            }
            mapper.updateUser(user);
            users = mapper.selectUserInfo(user.getId());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    /**
     * 添加实名认证
     * @param card
     */
    @Override
    public void addCard(Cards card) {
        Card card1 = new Card();
        BeanUtils.copyProperties(card, card1);
        mapper.addCard(card1);
        Integer cardId = card1.getId();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id", card.getUid());
        map.put("cardId", cardId);
        mapper.update(map);
    }

    /**
     * 查询用户所有信息
     * @param id
     * @return
     */
    @Override
    public Users select(Integer id) {
        return mapper.select(id);
    }

    /**
     * 更新实名认证信息
     * @param card
     */
    @Override
    public void updateCard(Cards card) {
        mapper.updateCard(card);
    }


    /**
     * 查询身份信息
     * @param id
     * @return
     */
    @Override
    public Card selectCard(Integer id) {
        Integer uid = mapper.selectCardId(id);
        System.out.println("avav："+uid);
        return mapper.selectCard(uid);
    }

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Override
    public Users selectUserInfo(Integer id) {
        return mapper.selectUserInfo(id);
    }

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    @Override
    public List<Nav> selectNav(Integer uid) {
        return mapper.selectNav(uid);
    }

    /**
     * 修改历史导航
     * @param uid
     */
    @Override
    public void deleteNav(Integer uid) {
        mapper.deleteNav(uid);
    }

    /**
     * 修改支付密码
     * @param users
     */
    @Override
    public void updatePayPassword(Users users) {
        mapper.updatePayPassword(users);
    }

    /**
     * 查询免密支付详情
     * @param id
     * @return
     */
    @Override
    public FreePay selectNoPayDetail(Integer id) {
        return mapper.selectNoPayDetail(id);
    }

    /**
     * 查询免密支付
     * @param uid
     * @return
     */
    @Override
    public List<FreePay> selectNoPayList(Integer uid) {
        return mapper.selectNoPay(uid);
    }
}
