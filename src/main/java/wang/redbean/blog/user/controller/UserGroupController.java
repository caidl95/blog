package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserGroupService;

/**
 * 权限控制器类
 */
@RestController
@RequestMapping("/user_group")
public class UserGroupController extends BaseController<IUserGroupService> {
}
