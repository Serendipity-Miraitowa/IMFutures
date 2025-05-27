package org.example.imfutures.service;

import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.CommentsInsert;

import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     * @param comment
     */
    void insert(CommentsInsert comment);

    /**
     * 用户查询自己的评论
     * @param id
     * @return
     */
    List<Comments> selectByUserId(int id);
}
