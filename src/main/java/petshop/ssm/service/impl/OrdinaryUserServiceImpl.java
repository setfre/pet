package petshop.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.execption.InLoginExecption;
import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.Role;
import petshop.ssm.service.BaseService;
import petshop.ssm.service.OrdinaryUserService;

@Service
public class OrdinaryUserServiceImpl extends BaseService implements OrdinaryUserService {

	/*******************************user***************************************/
	/**
	 * 登出
	 */
	@Override
	public ModelAndView exit() {
		// TODO Auto-generated method stub
		ModelAndView model = new ModelAndView();
		request.getSession().invalidate();
		model.setViewName("login");
		return model;
	}
	/**
	 * 登录
	 */
	@Override
	public ModelAndView login(HttpSession session,Master user) throws InLoginExecption{
		// TODO Auto-generated method stub
		ModelAndView model = null;
		
		//验证登录状态
		if("".equals(user.getLoginId())||"".equals(user.getLoginPwd())) {
			throw new InLoginExecption("账号或密码不能为空");
		}
		
		Master tuser = masterMapper.retrieveByUsercode(user);
		
		if(tuser == null) {
			throw new InLoginExecption("不存在此账户");
		}
		
		if(!tuser.getLoginPwd().equals(user.getLoginPwd())) {
			throw new InLoginExecption("密码错误");
		}
		
		//登录成功查询
		model = new ModelAndView();
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		request.getSession().setAttribute("user", tuser);
		request.getSession().setAttribute("operateStatus", tuser.getRoleId());
		
		//获得宠物信息
		Pagination<Pet> pets = ps.retrieveByAdoptTime(1, 4, 1);
		model.addObject("pagination", pets);
		
		//获得宠物种类
		model.addObject("pettypes", petTypeMapper.retrieveAll());
		
		//获得领养数
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", 1);
		model.addObject("isAdoped", petMapper.retrieveSizeByAdoptTime(status));
		
		//获得未被领养数
		status.clear();
		status.put("status", 2);
		model.addObject("isAdoping", petMapper.retrieveSizeByAdoptTime(status));
		
		//页面跳转
		model.setViewName("jsp/show");
		return model;
	}
	/**
	 * 注册
	 */
	@Override
	public void regist(Master user)  throws InLoginExecption{
		// TODO Auto-generated method stub
		if("".equals(user.getLoginId())||"".equals(user.getLoginPwd())) {
			throw new InLoginExecption("账号或密码不能为空");
		}
		
		Master tuser = masterMapper.retrieveByUsercode(user);
		
		if(tuser != null) {
			throw new InLoginExecption("已存在此用户");
		}
		
		masterMapper.create(user);
	}
	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(Master user) throws InLoginExecption {
		// TODO Auto-generated method stub
		if(user == null) {
			throw new InLoginExecption("更新失败");
		}
		
		masterMapper.update(user);
	}
	/**
	 * 获取用户分页
	 */
	@Override
	public Pagination<Master> retrieveUserPage(Integer currentIndex, Integer recordShowSize) {
		// TODO Auto-generated method stub
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, Master.class);
	}
	
	/*******************************role***************************************/
	
	public void createRole(Role role) {
		roleMapper.create(role);
	}
	
	public void deleteRole(Role role) {
		roleMapper.delete(role);
	}
	
	public void updateRole(Role role) {
		roleMapper.update(role);
	}
	
	public List<Role> retrieveAllRole() {
		return roleMapper.retrieveAll();
	}
	
	public Pagination<Role> retrieveRolePagination(Integer currentIndex,Integer recordShowSize){
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, Role.class);
	}


	
}
