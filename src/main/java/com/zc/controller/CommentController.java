package com.zc.controller;

import com.zc.domain.Comment;
import com.zc.service.CommentService;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*
    * 查询所有评论列表
    * @params commonPage
    * @params comment
    * */
    @PostMapping(value = "/list")
    public CommonResult getCommentList(CommonPage commonPage, Comment comment) {

        return commentService.getCommentList(commonPage, comment);
    }

    /*
    * 新增一个评论
    * @params comment
    * */
    @PostMapping(value = "/addOne")
    public CommonResult addOne(Comment comment) {

        return commentService.addOne(comment);
    }

    /*
    * 删除一条评论
    * @params id
    * */
    @GetMapping(value = "/deleteOne")
    public CommonResult deleteOne(Comment comment) {

        return commentService.deleteOne(comment);
    }
}
