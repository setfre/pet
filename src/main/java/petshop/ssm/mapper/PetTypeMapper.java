package petshop.ssm.mapper;

import java.util.List;

import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.PetType;

public interface PetTypeMapper extends BaseMapper<PetType>{

	List<Pet> retrieveByPetType(PetType petType);
}
