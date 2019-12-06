package wang.redbean.blog.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wang.redbean.blog.common.interceptor.LoginInterceptor;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径：必须登录才可以访问
        List<String> patterns = new ArrayList<>();
        patterns.add("/**");
        // 白名单：在黑名单范围内，却不需要登录就可以访问
        List<String> excludePatterns = new ArrayList<>();
        //样式
        excludePatterns.add("/comm/**");
        //接口
        excludePatterns.add("/users/**");
        //页面
        excludePatterns.add("/index.html");
        // 注册拦截器
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }

}





