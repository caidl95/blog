package wang.redbean.blog.core.base.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wang.redbean.blog.core.base.entity.constant.Const;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.entity.User;
import wang.redbean.blog.user.entity.UserMsg;
import javax.servlet.http.HttpSession;

/**
 * 控制器主类
 * @param <S>
 */
public class BaseController <S extends IService> {

    @Autowired
    protected S service;

    /**
     * 获取当前用户id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        User user = (User) session.getAttribute(Const.SESSION_KEY_USER_GROUP);
        if (user == null)
            throw new BaseException("session失效，请重新登录！");
        return user.getId();
    }

    /**
     * 获取当前用户权限
     */
    protected final User getUserFromSession(HttpSession session){
        User user = (User) session.getAttribute(Const.SESSION_KEY_USER_GROUP);
        if (user == null)
            throw new BaseException("session失效，请重新登录！");
        return user;
    }

    /**
     * 获取当前用户详细信息
     */
    protected final UserMsg getUserMsgFromSession(HttpSession session){
        UserMsg userMsg = (UserMsg) session.getAttribute(Const.SESSION_KEY_USER_MSG);
        if (userMsg == null)
            throw new BaseException("session失效，请重新登录！");
        return userMsg;
    }

    /**
     * 统一处理异常
     * @param e
     * @return
     */
    @ExceptionHandler({BaseException.class})
    public ServerResponse handleException(Throwable e) {
        if (e instanceof BaseException)
            return ServerResponse.createByErrorMessage(e.getMessage());
        return ServerResponse.createByErrorMessage("未知异常");
    }

}
