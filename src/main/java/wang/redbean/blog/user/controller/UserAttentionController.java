package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.model.response.ServerResponse;
import wang.redbean.blog.user.model.UserAttention;
import wang.redbean.blog.user.serivce.IUserAttentionService;

import javax.servlet.http.HttpSession;

/**
 * 用户关注控制器类
 */
@RestController
@RequestMapping("/user/attention")
public class UserAttentionController extends BaseController<IUserAttentionService> {

    @PostMapping("/save")
    public ServerResponse attentionByUserId( HttpSession session, UserAttention userAttention){
        userAttention.setUserId(getUidFromSession(session));
        boolean result = service.save(userAttention);
        if (result)
            return ServerResponse.createBySuccess("关注成功！");
        return ServerResponse.createByErrorMessage("关注失败！");
    }

    @PostMapping("/delete")
    public ServerResponse deleteAttentionByUserId( Integer attentionId){
        boolean result = service.removeById(attentionId);
        if (result)
            return ServerResponse.createBySuccess("取消关注成功！");
        return ServerResponse.createByErrorMessage("取消关注失败！");
    }

    @GetMapping("/get")
    public ServerResponse getUserAttention(HttpSession session){
        return ServerResponse.createBySuccess(service.getUserAttention(getUidFromSession(session)));
    }
}
