package wang.redbean.blog.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wang.redbean.blog.core.interceptor.LoginInterceptor;
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
        excludePatterns.add("/common/**");
        //接口
        excludePatterns.add("/users/reg");
        excludePatterns.add("/users/login");
        excludePatterns.add("/**/search");
        excludePatterns.add("/");
        //测试
        excludePatterns.add("/article/category/**");
        //页面
        excludePatterns.add("/index.html");
        excludePatterns.add("/login.html");
        excludePatterns.add("/register.html");
        excludePatterns.add("/tool.html");
        // 注册拦截器
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }

}





