package wang.redbean.blog.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wang.redbean.blog.common.base.entity.constant.Const;
import wang.redbean.blog.common.base.entity.response.ServerResponse;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.common.base.service.BaseService;
import wang.redbean.blog.user.entity.UserMsg;

import javax.servlet.http.HttpSession;

public class BaseController <S extends BaseService> {

    @Autowired
    protected S service;

    /**
     * 管理员
     */
    private static final Integer USER_ROLE_ADMIN = 0;

    /**
     * 普通用户
     */
    public static final Integer USER_ROLE_ORDINARY = 1;

  /**
     * 获取当前用户id
     */
  protected final Integer getUidFromSession(HttpSession session) {
        UserMsg user = (UserMsg) session.getAttribute(Const.SESSION_KEY_USER);
        return user.getUserId();
    }

    /**
     * 获取当前用户
     */
   protected final UserMsg getUserFromSession(HttpSession session){
        return (UserMsg)session.getAttribute(Const.SESSION_KEY_USER);
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
