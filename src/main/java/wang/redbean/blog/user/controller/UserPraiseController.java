package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserPriseService;

/**
 * 用户点赞控制器类
 */
@RestController
@RequestMapping("/user_praise")
public class UserPraiseController extends BaseController<IUserPriseService> {


}
