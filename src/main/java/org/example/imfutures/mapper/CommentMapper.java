package org.example.imfutures.mapper;


import org.apache.ibatis.annotations.Mapper;

import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.CommentsInsert;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 添加评论
     * @param comment
     */
    void insert(CommentsInsert comment);

    /**
     * 更新订单评论状态
     * @param comment
     */
    void update(CommentsInsert comment);

    /**
     * 用户查询自己的评论
     * @param id
     * @return
     */
    List<Comments> selectByUserId(int id);

    /**
     * 计算充电站平均分
     * @param id
     * @return
     */
    List<org.example.imfutures.pojo.Comments> selectShip(int id);
    void updateScore(Double score);

}
