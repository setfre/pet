package petshop.ssm.mapper;

import java.util.List;
import java.util.Map;

import petshop.ssm.pojo.Pet;

public interface PetMapper extends BaseMapper<Pet>{


	Integer retrieveSize();

	List<Pet> retrieveByAdoptTime(Map<String, Object> range);
	
	Integer retrieveSizeByAdoptTime(Map<String, Object> status);
	
	List<Pet> retrieveByManyKey(Map<String, Object> range);

	void adoptPet(Map<String, Object> map);
}
