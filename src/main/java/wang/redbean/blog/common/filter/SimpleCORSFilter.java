package wang.redbean.blog.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "simpleCORSFilter")
public class SimpleCORSFilter implements Filter {

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");  // 指定允许其他域名访问  * 允许所有
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");  // 预检请求的结果缓存60分钟
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");// 响应头设置
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
