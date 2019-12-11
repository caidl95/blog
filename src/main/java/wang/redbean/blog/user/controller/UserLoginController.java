package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.common.base.entity.response.ServerResponse;
import wang.redbean.blog.user.serivce.IUserLoginService;
import wang.redbean.blog.user.entity.param.UserLoginParam;
/**
 * 用户登录日志控制器类
 */
@RestController
@RequestMapping("/user_login")
public class UserLoginController extends BaseController<IUserLoginService> {

    @GetMapping("/get")
    public ServerResponse getAll(UserLoginParam userLoginParam){
        return ServerResponse.createBySuccess(service.getAllToStartAndCount(userLoginParam));
    }
}
