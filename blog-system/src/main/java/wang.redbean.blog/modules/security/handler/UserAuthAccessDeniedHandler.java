package wang.redbean.blog.modules.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import wang.redbean.blog.base.entity.response.ResponseCode;
import wang.redbean.blog.base.entity.response.ServerResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description 暂无权限处理类
 */
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 暂无权限返回结果
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception){
        ServerResponse.responseJson(response,ServerResponse.error(ResponseCode.NO_ACCESS.getCode(),ResponseCode.NO_ACCESS.getDesc()));
    }
}