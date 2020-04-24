package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.model.entity.UserPraise;
import wang.redbean.blog.article.serivce.IUserPriseService;
import wang.redbean.blog.base.controller.BaseController;

@RestController
@RequestMapping("/user_praise")
@Api("用户点赞控制器类")
public class UserPraiseController extends BaseController<IUserPriseService, UserPraise> {


}
