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
	 * �ǳ�
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
	 * ��¼
	 */
	@Override
	public ModelAndView login(HttpSession session,Master user) throws InLoginExecption{
		// TODO Auto-generated method stub
		ModelAndView model = null;
		
		//��֤��¼״̬
		if("".equals(user.getLoginId())||"".equals(user.getLoginPwd())) {
			throw new InLoginExecption("�˺Ż����벻��Ϊ��");
		}
		
		Master tuser = masterMapper.retrieveByUsercode(user);
		
		if(tuser == null) {
			throw new InLoginExecption("�����ڴ��˻�");
		}
		
		if(!tuser.getLoginPwd().equals(user.getLoginPwd())) {
			throw new InLoginExecption("�������");
		}
		
		//��¼�ɹ���ѯ
		model = new ModelAndView();
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		request.getSession().setAttribute("user", tuser);
		request.getSession().setAttribute("operateStatus", tuser.getRoleId());
		
		//��ó�����Ϣ
		Pagination<Pet> pets = ps.retrieveByAdoptTime(1, 4, 1);
		model.addObject("pagination", pets);
		
		//��ó�������
		model.addObject("pettypes", petTypeMapper.retrieveAll());
		
		//���������
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("status", 1);
		model.addObject("isAdoped", petMapper.retrieveSizeByAdoptTime(status));
		
		//���δ��������
		status.clear();
		status.put("status", 2);
		model.addObject("isAdoping", petMapper.retrieveSizeByAdoptTime(status));
		
		//ҳ����ת
		model.setViewName("jsp/show");
		return model;
	}
	/**
	 * ע��
	 */
	@Override
	public void regist(Master user)  throws InLoginExecption{
		// TODO Auto-generated method stub
		if("".equals(user.getLoginId())||"".equals(user.getLoginPwd())) {
			throw new InLoginExecption("�˺Ż����벻��Ϊ��");
		}
		
		Master tuser = masterMapper.retrieveByUsercode(user);
		
		if(tuser != null) {
			throw new InLoginExecption("�Ѵ��ڴ��û�");
		}
		
		masterMapper.create(user);
	}
	/**
	 * �����û���Ϣ
	 */
	@Override
	public void updateUser(Master user) throws InLoginExecption {
		// TODO Auto-generated method stub
		if(user == null) {
			throw new InLoginExecption("����ʧ��");
		}
		
		masterMapper.update(user);
	}
	/**
	 * ��ȡ�û���ҳ
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
