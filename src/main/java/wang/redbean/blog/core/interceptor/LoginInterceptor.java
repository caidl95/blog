package wang.redbean.blog.core.interceptor;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wang.redbean.blog.core.base.entity.constant.Const;
import wang.redbean.blog.user.entity.Role;
import wang.redbean.blog.user.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 请求时处理之前前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute(Const.SESSION_KEY_USER_GROUP);
		if (user == null) {//不在白名单内必须登录
			response.sendRedirect("/login.html");
			return false;
		}
		// 请求的方法是否有注解
		boolean haveAnnotation = handler.getClass().isAssignableFrom(HandlerMethod.class);
		if (haveAnnotation) {
			// 检测是否有 @OnlyAdmin 注解
			OnlyAdmin oa = ((HandlerMethod)handler).getMethodAnnotation(OnlyAdmin.class);
			if (oa != null) {
				// 如果有 @OnlyAdmin则表明该方法只允许管理员删除
				String [] array = oa.value();
				for (String arr : array){
					for (Role role : ((User)user).getRoles()){
						if (arr.equals(role.getName())){
							//如果注解上跟权限内一致则有此权限
							return true;
						}
					}
				}
				// 如果遍历完还能往下走则没有该权限
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/json;charset=utf-8");
				PrintWriter pw = response.getWriter();
				pw.flush();
				pw.println("{\"msg\":\"你未有该权限\"}");
				return false;
			}
		}
		// 用户已登录，则返回true, 放行该请求
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }

	/**
	 * 请求时处理完之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
