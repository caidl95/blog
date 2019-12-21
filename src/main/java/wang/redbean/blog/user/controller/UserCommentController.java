package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserCommentService;

/**
 * 用户评论控制器类
 */
@RestController
@RequestMapping("/user_comment")
public class UserCommentController extends BaseController<IUserCommentService> {

}
