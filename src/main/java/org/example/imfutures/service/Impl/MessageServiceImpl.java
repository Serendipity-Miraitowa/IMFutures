package org.example.imfutures.service.Impl;

import org.example.imfutures.mapper.MessageMapper;
import org.example.imfutures.pojo.Message;
import org.example.imfutures.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper mapper;

    /**
     * 用户阅读后更新消息状态为已读
     * @param id
     */
    @Override
    public void updateMessageStatus(Integer uid, Integer id) {
        mapper.updateMessageStatus(uid, id);
    }

    /**
     * 批量更新消息状态为已读
     * @param uid
     */
    @Override
    public void updateMessageAll(Integer uid) {
        mapper.updateAll(uid);
    }

    /**
     * 查询已阅读消息
     * @param id
     * @return
     */
    @Override
    public List<Message> messages(Integer id) {
       return mapper.messages(id);
    }

    /**
     * 查询未阅读消息
     * @param id
     * @return
     */
    @Override
    public List<Message> messagesNoRead(Integer id) {
        return mapper.messagesNoRead(id);
    }
}
