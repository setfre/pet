package petshop.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.execption.InLoginExecption;
import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.service.OrdinaryUserService;
import petshop.ssm.service.PetService;

@Controller
@RequestMapping("userResourse")
public class OrdinaryUserController {
	
	@Autowired
	private OrdinaryUserService ordinaryUserService;
	
	/*******************************user***************************************/
	/**
	 * message ��ʾ��Ϣ
	 * status :
	 * 		100 ��¼ʧ��
	 * 		101 ע��ʧ��
	 * 		102 ע��ɹ�
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("doLogin")
	public ModelAndView doLogin(HttpSession session,Master user) {
		ModelAndView model = null;
		//�����¼�쳣��Ϣ
		try {
			model = ordinaryUserService.login(session,user);
		} catch (InLoginExecption e) {
			model = new ModelAndView();
			model.addObject("message", e.getMessage());
			model.addObject("status",100);
			model.setViewName("login");
		}
		return model;
	}
	
	@RequestMapping("doRegist")
	public ModelAndView doRegist(Master user) {
		
		ModelAndView model = new ModelAndView();
		
		try {
			ordinaryUserService.regist(user);//message pageTo
			
		} catch (InLoginExecption e) {
			model.addObject("message", e.getMessage());
			model.addObject("status",101);
			model.setViewName("login");
			return model; 
		}
		model.addObject("message", "ע��ɹ�");
		model.addObject("status",102);
		model.setViewName("login");
		return model;
	}
	@RequestMapping("doExit")
	public ModelAndView doExit() {
		return ordinaryUserService.exit();
	}
	@RequestMapping("doUpdate")
	public String doUpdate(ModelAndView model,Master user) {
		try {
			ordinaryUserService.updateUser(user);
		} catch (InLoginExecption e) {
			model.addObject("message", e.getMessage());
			return "login";
		}
		model.addObject("message", "���³ɹ�");
		return "jsp/show";
	}
	
	@RequestMapping("/admin/doRetrieveUser")
	public ModelAndView doRetrieveUserPage(Integer currentIndex,Integer recordShowSize) {
		ModelAndView model = new ModelAndView();
		Pagination<Master> users = ordinaryUserService.retrieveUserPage(currentIndex,recordShowSize);
		model.addObject("users", users);
		model.setViewName("jsp/show");
		return model;
	}
	
	@RequestMapping("toLogin")
	public ModelAndView toLoginPage(Integer operateStatus) {
		ModelAndView model = new ModelAndView();
		model.addObject("operateStatus", operateStatus);
		model.setViewName("login");
		return model;
	}
	/*
	@RequestMapping("toRegist")
	public String toRegistPage(Integer operateStatus) {
		
		return "redirect:login.jsp?operate=2";
	}
	*/
	/*******************************role***************************************/
	
}
