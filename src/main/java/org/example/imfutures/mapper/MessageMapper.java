package org.example.imfutures.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.imfutures.pojo.Message;

import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 用户阅读后更新消息状态为已读
     * @param id
     * @param uid
     */
    @Update("update message set status = 0 where user_id = #{uid} and id = #{id}")
    void updateMessageStatus(Integer uid, Integer id);

    /**
     * 批量阅读
     * @param uid
     */
    @Update(("update message set status = 0 where user_id = #{uid}"))
    void updateAll(Integer uid);

    /**
     * 查询已阅读消息
     * @param id
     * @return
     */
    @Select("select * from message where user_id = #{id} and status = 0 order by id desc")
    List<Message> messages(Integer id);

    /**
     * 查询未阅读消息
     * @param id
     * @return
     */
    @Select("select * from message where user_id = #{id} and status = 1 order by id desc")
    List<Message> messagesNoRead(Integer id);

    /**
     * 发送注册成功通知
     * @param message
     */
    @Insert("insert into message(content, date, title, status, user_id) values(#{content}, #{date}, #{title}, #{status}, #{userId})")
    void insertMessage(Message message);
}
