package org.example.imfutures.service;

import org.apache.ibatis.annotations.Select;
import org.example.imfutures.pojo.Message;

import java.util.List;

public interface MessageService {

    /**
     * 用户阅读后更新消息状态为已读
     * @param id
     * @param uid
     */
    void updateMessageStatus(Integer uid, Integer id);

    /**
     * 批量更新消息状态为已读
     * @param uid
     */
    void updateMessageAll(Integer uid);

    /**
     * 查询已阅读消息
     * @param id
     * @return
     */
    List<Message> messages(Integer id);

    /**
     * 查询未阅读消息
     * @param id
     * @return
     */
    List<Message> messagesNoRead(Integer id);
}
