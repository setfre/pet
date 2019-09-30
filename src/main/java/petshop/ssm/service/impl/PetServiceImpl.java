package petshop.ssm.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.mchange.v2.codegen.bean.BeangenUtils;

import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.PetType;
import petshop.ssm.service.BaseService;
import petshop.ssm.service.PetService;
import petshop.ssm.utils.BeanUtil;

@Service
public class PetServiceImpl extends BaseService implements PetService{

	/*******************************pet***************************************/
	
	/**
	 * 添加宠物
	 */
	@Override
	public void createPet(Pet pet) {
		pet.setAddTime(new Date());
		petMapper.create(pet);
	}
	/**
	 * 删除宠物
	 */
	@Override
	public void deletePet(Pet pet) {
		petMapper.delete(pet); 
	}
	/**
	 * 更新宠物信息
	 */
	@Override
	public void updatePet(Pet pet) {
		petMapper.update(pet);
	}
	/**
	 * 按宠物id查询
	 */
	@Override
	public Pet retrieveByPetId(Pet pet) {
		return petMapper.retrieveById(pet);
	}
	/**
	 * 查询所有宠物并分页
	 */
	@Override
	public Pagination<Pet> retrievePetPage(Integer currentIndex,Integer recordShowSize) {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, Pet.class);
	}
	/**
	 * 领养宠物
	 */
	@Override
	public ModelAndView adoptPet(Integer masterId, Integer petId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("masterId", masterId);
		map.put("petId", petId);
		map.put("data", new Date());
		petMapper.adoptPet(map);
		ModelAndView model = getPetModel();
		model.addObject("message","领养成功");
		model.setViewName("jsp/show");
		return model;
	}
	/**
	 * 归还宠物
	 * @param petId
	 * @return
	 */
	public ModelAndView sendBackPet(Integer petId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petId", petId);
		petMapper.adoptPet(map);
		ModelAndView model = getPetModel();
		model.addObject("message","领养成功");
		model.setViewName("jsp/show");
		return model;
	}
	
	/*******************************pettype***************************************/
	
	/**
	 * 添加宠物类型
	 */
	public void createPetType(PetType petType) {
		petTypeMapper.create(petType);
	}
	/**
	 * 删除宠物类型
	 */
	public void deletePetType(PetType petType) {
		petTypeMapper.delete(petType);
	}
	/**
	 * 更新宠物类型信息
	 */
	public void updatePetType(PetType petType) {
		petTypeMapper.update(petType);
	}
	/**
	 * 查询全部宠物类型
	 */
	public List<PetType> retrieveAllPetType() {
		return petTypeMapper.retrieveAll();
	}
	/**
	 * 根据宠物类型id查询
	 */
	@Override
	public ModelAndView retrieveByPetTypeId(PetType petType) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据宠物类型分页查询
	 */
	public Pagination<PetType> retrievePetTypePage(Integer currentIndex,Integer recordShowSize) {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, PetType.class);
	}
	/**
	 * 根据宠物类型字段分页查询
	 */
	@Override
	public ModelAndView retrievePetByPetType(Integer petypeId, Integer adoptStatus) {
		// TODO Auto-generated method stub
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		
		ModelAndView model = new ModelAndView();
		
		//获得宠物信息
		model.addObject("pagination", ps.retrievePetByPetType(petypeId,adoptStatus));
		
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
		
		model.setViewName("jsp/show");
		return model;
	}
	@Override
	public ModelAndView retrievePet() {
		// TODO Auto-generated method stub
		return retrievePetByPetType(0,0);
	}
	public ModelAndView getPetModel() {
		
		ModelAndView model = new ModelAndView();

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
		
		model.setViewName("jsp/show");
		return model;
	}

	
}
