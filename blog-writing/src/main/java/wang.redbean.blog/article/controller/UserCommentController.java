package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.model.entity.UserComment;
import wang.redbean.blog.article.serivce.IUserCommentService;
import wang.redbean.blog.base.controller.BaseController;

@RestController
@RequestMapping("/user_comment")
@Api("用户评论控制器类")
public class UserCommentController extends BaseController<IUserCommentService, UserComment> {

}
