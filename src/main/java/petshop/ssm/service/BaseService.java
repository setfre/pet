package petshop.ssm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import petshop.ssm.mapper.MasterMapper;
import petshop.ssm.mapper.PetMapper;
import petshop.ssm.mapper.PetTypeMapper;
import petshop.ssm.mapper.RoleMapper;

public abstract class BaseService {

	@Autowired
	protected MasterMapper masterMapper;
	@Autowired
	protected PetMapper petMapper;
	@Autowired
	protected RoleMapper roleMapper;
	@Autowired
	protected PetTypeMapper petTypeMapper;
	@Autowired
	protected HttpServletRequest request;
}
