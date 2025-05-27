package org.example.imfutures.service.Impl;


import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.CommentsInsert;
import org.example.imfutures.mapper.CommentMapper;
import org.example.imfutures.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper mapper;

    /**
     * 添加评论
     * @param comment
     */
    @Override
    public void insert(CommentsInsert comment) {
        mapper.insert(comment);
        CommentsInsert insert = new CommentsInsert();
        BeanUtils.copyProperties(comment, insert);
        mapper.update(insert);
    }

    /**
     * 查询用户评论
     * @param id
     * @return
     */
    @Override
    public List<Comments> selectByUserId(int id) {
        return mapper.selectByUserId(id);
    }
}
