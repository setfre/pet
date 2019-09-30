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
	 * ��ӳ���
	 */
	@Override
	public void createPet(Pet pet) {
		pet.setAddTime(new Date());
		petMapper.create(pet);
	}
	/**
	 * ɾ������
	 */
	@Override
	public void deletePet(Pet pet) {
		petMapper.delete(pet); 
	}
	/**
	 * ���³�����Ϣ
	 */
	@Override
	public void updatePet(Pet pet) {
		petMapper.update(pet);
	}
	/**
	 * ������id��ѯ
	 */
	@Override
	public Pet retrieveByPetId(Pet pet) {
		return petMapper.retrieveById(pet);
	}
	/**
	 * ��ѯ���г��ﲢ��ҳ
	 */
	@Override
	public Pagination<Pet> retrievePetPage(Integer currentIndex,Integer recordShowSize) {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, Pet.class);
	}
	/**
	 * ��������
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
		model.addObject("message","�����ɹ�");
		model.setViewName("jsp/show");
		return model;
	}
	/**
	 * �黹����
	 * @param petId
	 * @return
	 */
	public ModelAndView sendBackPet(Integer petId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petId", petId);
		petMapper.adoptPet(map);
		ModelAndView model = getPetModel();
		model.addObject("message","�����ɹ�");
		model.setViewName("jsp/show");
		return model;
	}
	
	/*******************************pettype***************************************/
	
	/**
	 * ��ӳ�������
	 */
	public void createPetType(PetType petType) {
		petTypeMapper.create(petType);
	}
	/**
	 * ɾ����������
	 */
	public void deletePetType(PetType petType) {
		petTypeMapper.delete(petType);
	}
	/**
	 * ���³���������Ϣ
	 */
	public void updatePetType(PetType petType) {
		petTypeMapper.update(petType);
	}
	/**
	 * ��ѯȫ����������
	 */
	public List<PetType> retrieveAllPetType() {
		return petTypeMapper.retrieveAll();
	}
	/**
	 * ���ݳ�������id��ѯ
	 */
	@Override
	public ModelAndView retrieveByPetTypeId(PetType petType) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * ���ݳ������ͷ�ҳ��ѯ
	 */
	public Pagination<PetType> retrievePetTypePage(Integer currentIndex,Integer recordShowSize) {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		return ps.getPagination(currentIndex, recordShowSize, PetType.class);
	}
	/**
	 * ���ݳ��������ֶη�ҳ��ѯ
	 */
	@Override
	public ModelAndView retrievePetByPetType(Integer petypeId, Integer adoptStatus) {
		// TODO Auto-generated method stub
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		PaginationService ps = (PaginationService) applicationContext.getBean("paginationService");
		
		ModelAndView model = new ModelAndView();
		
		//��ó�����Ϣ
		model.addObject("pagination", ps.retrievePetByPetType(petypeId,adoptStatus));
		
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
		
		model.setViewName("jsp/show");
		return model;
	}

	
}
