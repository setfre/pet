package petshop.ssm.service;

import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.PetType;

public interface PetService {

	Pagination<Pet> retrievePetPage(Integer currentIndex,Integer recordShowSize);

	void updatePet(Pet pet);

	void deletePet(Pet pet);

	void createPet(Pet pet);

	Pet retrieveByPetId(Pet pet);

	ModelAndView retrieveByPetTypeId(PetType petType);

	ModelAndView retrievePetByPetType(Integer petypeId, Integer adoptStatus);

	ModelAndView adoptPet(Integer masterId, Integer petId);

	ModelAndView retrievePet();

	void createPetType(PetType petType);

}
