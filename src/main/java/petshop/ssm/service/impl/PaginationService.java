package petshop.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


import petshop.ssm.mapper.BaseMapper;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.service.BaseService;

/**
 * Spring在代码中获取bean的几种方式
 * https://www.cnblogs.com/yjbjingcha/p/6752265.html
 */
@Service
public class PaginationService extends BaseService{

	
	public<T> Pagination<T> getPagination(Integer currentIndex,Integer recordShowSize,
			Class<T> beanClass){
		String beanName = beanClass.getName();
		if(beanName == null) {
			return null;
		}
		System.out.println("我被调用啦"+beanName);
		BaseMapper baseMapper = null;
		if(beanName.indexOf("Master")>-1) {
			baseMapper = masterMapper;
		}
		else if(beanName.indexOf("Role")>-1) {
			baseMapper = roleMapper;
		}
		else if(beanName.indexOf("Pet")>-1) {
			baseMapper = petMapper;
		}
		else if(beanName.indexOf("PetType")>-1) {
			baseMapper = petTypeMapper;
		}
		else {
			return null;
		}
		Pagination<T> pagination = new Pagination<T>();
		pagination.setDbRecordSize(baseMapper.retrieveSize());
		pagination.setRecordShowSize(recordShowSize);
		pagination.setCurrentIndex(currentIndex); 
		pagination.setBean(baseMapper.pagination(pagination.getRange()));
		return pagination;
	}
	public Pagination<Pet> retrieveByAdoptTime(Integer currentIndex,Integer recordShowSize,Integer status){
		Pagination<Pet> pagination = new Pagination<Pet>();
		pagination.setDbRecordSize(petMapper.retrieveSize());
		pagination.setRecordShowSize(recordShowSize);
		pagination.setCurrentIndex(currentIndex); 
		Map<String, Object> range = pagination.getRange();
		range.put("status", status);
		pagination.setBean(petMapper.retrieveByAdoptTime(range));
		System.out.println(petMapper.retrieveByAdoptTime(range));
		return pagination;
	}
	public Pagination<Pet> retrieveByManyKey(Integer currentIndex,Integer recordShowSize,
			Map<String, Object> map){
		Pagination<Pet> pagination = new Pagination<Pet>();
		pagination.setDbRecordSize(petMapper.retrieveSize());
		pagination.setRecordShowSize(recordShowSize);
		pagination.setCurrentIndex(currentIndex); 
		Map<String, Object> range = pagination.getRange();
		map.putAll(range);
		System.out.println(map);
		pagination.setBean(petMapper.retrieveByManyKey(map));
		return pagination;
	}

	public Pagination<Pet> retrievePetByPetType(Integer petypeId, Integer adoptStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", petypeId);
		map.put("adoptStatus", adoptStatus);
		return retrieveByManyKey(1, 4, map);
	}
	
	
}
