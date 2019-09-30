package petshop.ssm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.execption.InLoginExecption;
import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Role;

public interface OrdinaryUserService {

	ModelAndView login(HttpSession session,Master user) throws InLoginExecption;

	void regist(Master user) throws InLoginExecption;

	void updateUser(Master user) throws InLoginExecption;

	Pagination<Master> retrieveUserPage(Integer currentIndex, Integer recordShowSize);

	List<Role> retrieveAllRole();

	ModelAndView exit(); 
}
