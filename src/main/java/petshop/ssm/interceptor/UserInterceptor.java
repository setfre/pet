package petshop.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.pojo.Master;

 
public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		/**
		 * operateStatus:3  	访客
		 * operateStatus:1		普通用户
		 * operateStatus:2		管理员
		 */
		Master user = null;
		
		//验证普通用户
		user = (Master) request.getSession().getAttribute("user");
		if(user != null && user.getRoleId() == 1) {
			return true;
		}
		request.setAttribute("message", "请先登录");
		request.setAttribute("status", 101);
		request.getRequestDispatcher("../../userResourse/toLogin.action").forward(request, response);
		/*
		 * response.sendRedirect("");
		 */		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
