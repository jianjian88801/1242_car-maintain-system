package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Comment;

import java.util.List;

public interface CommentMapper {

    int insert(Comment record);


    /**
     * 查询所有有效的权限
     * @return
     */
    List<Comment> selectAllComments();
    
}