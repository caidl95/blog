package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.constant.Const;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.serivce.IUserMsgService;
import javax.servlet.http.HttpSession;

/**
 *  用户信息控制器类
 */
@RestController
@RequestMapping("/user/msg")
public class UserMsgController extends BaseController<IUserMsgService> {


    /**
     * 在线修改个人信息
     */
    @PostMapping("/update")
    public ServerResponse updateInformation(HttpSession session, UserMsg userMsg){
        //用户资料只允许当前登录的用户进行修改
        userMsg.setUserId( getUidFromSession(session));
        boolean result = service.save(userMsg);
        if (result){
            //将修改后的信息覆盖进入session中
            session.setAttribute(Const.SESSION_KEY_USER_MSG ,userMsg);
            return ServerResponse.createBySuccess("用户信息修改成功！");
        }
        return ServerResponse.createByErrorMessage("用户信息修改时出现未知异常！");
    }

    /**
     * 获取当前用户的登录详细信息
     * @param session
     * @return
     */
    @GetMapping("/get")
    public ServerResponse getUserMsgInfo(HttpSession session){
        return ServerResponse.createBySuccess(getUserMsgFromSession(session));
    }

}
