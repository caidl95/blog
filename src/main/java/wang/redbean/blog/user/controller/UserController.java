package wang.redbean.blog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.constant.Const;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.core.util.IpUtil;
import wang.redbean.blog.user.entity.User;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.serivce.IUserMsgService;
import wang.redbean.blog.user.serivce.IUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("/users")
public class UserController extends BaseController<IUserService> {

    @Autowired
    private IUserMsgService userMsgService;

    @PostMapping("/reg")
    public ServerResponse reg( String username, String password){
        boolean result = service.reg(username,password);
        if (result)
            return ServerResponse.createBySuccess("注册成功！");
        return ServerResponse.createByErrorMessage("注册失败！");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ServerResponse login(HttpServletRequest request, HttpSession session, String username, String password){
        String loginIp = IpUtil.getUserIP(request);
        //验证账号密码
        User user = service.login(username,password,loginIp);
        user.setPassword(null);//登录后隐藏密码
        //将登录的用户信息及权限存进session
        session.setAttribute(Const.SESSION_KEY_USER_GROUP, user);
        //将详细信息放入session中
        UserMsg userMsg = userMsgService.getByUserId(user.getId());
        if (userMsg!=null)
            session.setAttribute( Const.SESSION_KEY_USER_MSG, userMsg);
        return ServerResponse.createBySuccess(userMsg);
    }

    /**
     * 获取当前登录用户基本信息
     */
    @GetMapping("/get")
    public ServerResponse<User> getUserInfo(HttpSession session){
        return ServerResponse.createBySuccess(getUserFromSession(session));
    }

    /**
     * 在线更改密码
     */
    @PostMapping("/reset_password")
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew, HttpServletResponse response){
        boolean result = service.resetPassword(passwordOld,passwordNew,getUidFromSession(session));
        if (result) {
            session.removeAttribute(Const.SESSION_KEY_USER_GROUP);
            try {
                response.sendRedirect("/login.html");
            } catch (IOException e) {
                throw new BaseException("在线修改密码时重定向失败");
            }
        }
        return ServerResponse.createByErrorMessage("在线修改密码出现未知异常");
    }

    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public ServerResponse logout(HttpSession session){
        session.removeAttribute(Const.SESSION_KEY_USER_GROUP);
        session.removeAttribute(Const.SESSION_KEY_USER_MSG);
        return ServerResponse.createBySuccess();
    }
}
