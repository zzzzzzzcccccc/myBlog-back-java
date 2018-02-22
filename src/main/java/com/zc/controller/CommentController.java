package com.zc.controller;

import com.zc.domain.Comment;
import com.zc.service.CommentService;
import com.zc.utils.CommonDateTime;
import com.zc.utils.CommonPage;
import com.zc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*
    * 查询所有评论列表
    * @params commonPage
    * @params comment
    * @params commonDateTime
    * */
    @GetMapping(value = "/list")
    public CommonResult getCommentList(CommonPage commonPage, Comment comment, CommonDateTime commonDateTime) {

        return commentService.getCommentList(commonPage, comment, commonDateTime);
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
