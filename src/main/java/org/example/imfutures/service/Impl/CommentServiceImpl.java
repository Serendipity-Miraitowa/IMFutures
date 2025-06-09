package org.example.imfutures.service.Impl;


import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.CommentsInsert;
import org.example.imfutures.mapper.CommentMapper;
import org.example.imfutures.pojo.ChargingStations;
import org.example.imfutures.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
        averageScore(comment.getChargingStationId());
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

    /**
     * 计算单个充电站的评论平均分
     * @param id
     * @return
     */
    private void averageScore(int id){
        DecimalFormat df = new DecimalFormat("#.0");
        List<org.example.imfutures.pojo.Comments> comments = mapper.selectShip(id);
        double totalScore = 0;
        int commentCount = 0;

        for (org.example.imfutures.pojo.Comments comment : comments) {
            totalScore += comment.getScore();
            commentCount++;
        }

        if (commentCount > 0) {
            double averageScore = totalScore / commentCount;
            averageScore = Double.parseDouble(df.format(averageScore));
            mapper.updateScore(averageScore);
        } else {
            // 如果没有评论，设置默认值， 0
            mapper.updateScore(0.0);
        }
    }
}
