package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.common.base.entity.constant.Const;
import wang.redbean.blog.common.base.entity.response.ServerResponse;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.serivce.IUserMsgService;

import javax.servlet.http.HttpSession;

/**
 *  用户信息控制器类
 */
@RestController
@RequestMapping("/user_msg")
public class UserMsgController extends BaseController<IUserMsgService> {

    /**
     * 注册
     */
    @PostMapping("/sign_in")
    public ServerResponse<String> signIn(UserMsg userMsg){
        boolean result = service.save(userMsg);
        if (result){
            return ServerResponse.createBySuccess("注册成功！");
        }
        return ServerResponse.createByErrorMessage("注册时发现未知异常！");
    }

    /**
     * 在线修改个人信息
     */
    @PostMapping("/update_information")
    public ServerResponse updateInformation(HttpSession session, UserMsg userMsg){
        //id与name由session中取出保证不被更改
        UserMsg currentUserMsg = getUserFromSession(session);
        userMsg.setUserId(currentUserMsg.getUserId());
        userMsg.setUserName(currentUserMsg.getUserName());
        boolean result = service.updateById(userMsg);
        if (result){
            session.setAttribute(Const.SESSION_KEY_USER ,userMsg);
            session.setMaxInactiveInterval(3600);
            return ServerResponse.createBySuccess("修改成功！");
        }
        return ServerResponse.createByErrorMessage("修改时出现未知异常！");
    }

}
