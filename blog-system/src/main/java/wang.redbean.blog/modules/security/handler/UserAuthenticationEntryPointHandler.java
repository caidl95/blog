package wang.redbean.blog.modules.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import wang.redbean.blog.base.entity.response.ResponseCode;
import wang.redbean.blog.base.entity.response.ServerResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户未登录处理类
 */
@Component
public class UserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    /**
     * 用户未登录返回结果
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        ServerResponse.responseJson(response, ServerResponse.error( ResponseCode.NO_LOGIN.getCode(), ResponseCode.NO_LOGIN.getDesc()));
    }
}