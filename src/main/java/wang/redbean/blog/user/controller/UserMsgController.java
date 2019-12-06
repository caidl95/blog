package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserMsgSerivce;

@RestController
@RequestMapping("/user_msg")
public class UserMsgController extends BaseController<IUserMsgSerivce> {


}
