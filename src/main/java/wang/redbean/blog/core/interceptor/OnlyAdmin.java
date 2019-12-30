package wang.redbean.blog.core.interceptor;

import java.lang.annotation.*;

/**
 * 权限注解，当使用此注解时则登录拦截器会进行拦截验证
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyAdmin {

    String[] value();

}
