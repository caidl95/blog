package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.user.serivce.IUserAttentionService;

/**
 * 用户关注控制器类
 */
@RestController
@RequestMapping("/user_attention")
public class UserAttentionController extends BaseController<IUserAttentionService> {

}
