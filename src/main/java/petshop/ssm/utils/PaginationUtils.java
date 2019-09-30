package petshop.ssm.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import petshop.ssm.mapper.BaseMapper;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.service.BaseService;

/**
 * Spring在代码中获取bean的几种方式
 * https://www.cnblogs.com/yjbjingcha/p/6752265.html
 */
@Service
public class PaginationUtils extends BaseService implements ApplicationContextAware{

	@Autowired
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext; 
	}
	@PostConstruct
	public void init() {
		System.out.println("我被装载啦");
	}
	
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

}
