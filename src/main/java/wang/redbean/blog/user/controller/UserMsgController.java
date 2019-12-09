package wang.redbean.blog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.common.base.entity.constant.Const;
import wang.redbean.blog.common.base.entity.response.ServerResponse;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.entity.vo.UserGroupVo;
import wang.redbean.blog.user.entity.vo.UserMsgVo;
import wang.redbean.blog.user.serivce.IUserGroupService;
import wang.redbean.blog.user.serivce.IUserMsgService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *  用户信息控制器类
 */
@RestController
@RequestMapping("/user_msg")
public class UserMsgController extends BaseController<IUserMsgService> {

    @Autowired
    private IUserGroupService userGroupService;

    /**
     * 注册
     */
    @PostMapping("/sign_in")
    public ServerResponse<String> signIn(UserMsg userMsg){
        boolean result = service.save(userMsg);
        if (result){
            return ServerResponse.createBySuccess("新用户注册成功！");
        }
        return ServerResponse.createByErrorMessage("新用户注册时发现未知异常！");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ServerResponse<UserMsg> login(HttpSession session, String userName, String userPassword){
        //验证账号密码
        UserMsgVo userMsg = service.login(userName,userPassword);
        //将当前登录的用户权限查找出来
        List<UserGroupVo> userGroupVoList = userGroupService.selectByUserId(userMsg.getUserId());
        //放入userMsgVo类
        userMsg.setUserGroupVoList(userGroupVoList);
        //将登录的用户信息及权限存进session
        session.setAttribute(Const.SESSION_KEY_USER, userMsg);
        session.setMaxInactiveInterval(3600);
        return ServerResponse.createBySuccess(userMsg);
    }

    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public ServerResponse logout(HttpSession session){
        session.removeAttribute(Const.SESSION_KEY_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 获取当前登录用户信息
     */
    @GetMapping("/get_user")
    public ServerResponse<UserMsgVo> getUserInfo(HttpSession session){
        return ServerResponse.createBySuccess(getUserFromSession(session));
    }

    /**
     * 在线修改个人信息
     */
    @PostMapping("/update_information")
    public ServerResponse updateInformation(HttpSession session, UserMsg userMsg){
        //id与name由session中取出保证不被更改,密码不被串改
        UserMsgVo currentUserMsg = getUserFromSession(session);
        userMsg.setUserId(currentUserMsg.getUserId());
        userMsg.setUserName(currentUserMsg.getUserName());
        userMsg.setUserPassword(null);
        boolean result = service.updateById(userMsg);
        if (result){
            //将修改后的信息覆盖进入session中
            session.setAttribute(Const.SESSION_KEY_USER ,userMsg);
            return ServerResponse.createBySuccess("用户信息修改成功！");
        }
        return ServerResponse.createByErrorMessage("用户信息修改时出现未知异常！");
    }

    /**
     * 在线更改密码
     */
    @PostMapping("/reset_password")
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew, HttpServletResponse response){
        boolean result = service.resetPassword(passwordOld,passwordNew,getUidFromSession(session));
        if (result) {
            session.removeAttribute(Const.SESSION_KEY_USER);
            try {
                //TODO 页面需更新
                response.sendRedirect("/index.html");
            } catch (IOException e) {
                throw new BaseException("在线修改密码时重定向失败");
            }
        }
        return ServerResponse.createByErrorMessage("在线修改密码出现未知异常");
    }


}
