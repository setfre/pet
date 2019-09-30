package petshop.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.pojo.Master;
public class AdminInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Master user = null;
		//��֤����Ա
		user = (Master) request.getAttribute("user");
		if(user != null && user.getRoleId() == 2) {
			return true;
		}
		request.setAttribute("message", "���ȵ�¼");
		request.setAttribute("status", 101);
		request.getRequestDispatcher("../../userResourse/toLogin.action").forward(request, response);
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
