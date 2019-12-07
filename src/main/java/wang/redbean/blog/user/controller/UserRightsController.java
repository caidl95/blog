package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserRightsService;

/**
 * 用户权限控制器类
 */
@RestController
@RequestMapping("/user_rights")
public class UserRightsController extends BaseController<IUserRightsService> {

}
