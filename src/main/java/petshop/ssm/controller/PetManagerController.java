package petshop.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.PetType;
import petshop.ssm.service.PetService;

@Controller
@RequestMapping("petResourse")
public class PetManagerController {

	
	@Autowired
	private PetService petService;
	
	/*******************************pet***************************************/
	/**
	 * 添加宠物
	 * @param pet
	 * @return
	 */
	@RequestMapping("/admin/doCreatePet")
	public ModelAndView doCreatePet(Pet pet) {
		petService.createPet(pet);
		return petService.retrievePet();
	}
	/**
	 * 更新宠物信息
	 * @param pet
	 * @return
	 */
	@RequestMapping("/admin/doUpdatePet")
	public ModelAndView doUpdatePet(Pet pet) {
		petService.updatePet(pet);
		return petService.retrievePet();
	}
	/**
	 * 删除宠物
	 * @param pet
	 * @return
	 */
	@RequestMapping("/admin/doDeletePet")
	public ModelAndView doDeletePet(Pet pet) {
		petService.deletePet(pet);
		return petService.retrievePet();
	}
	/**
	 * 查询宠物页面
	 * @param currentIndex
	 * @param recordShowSize
	 * @param petypeId
	 * @param adoptStatus
	 * @return
	 */
	public ModelAndView doRetrievePetPage(Integer currentIndex,Integer recordShowSize,
			Integer petypeId,Integer adoptStatus) {
		Pagination<Pet> pets = petService.retrievePetPage(currentIndex,recordShowSize);
		System.out.println(pets);
		ModelAndView model = new ModelAndView();
		model.addObject("pagination", pets);
		model.setViewName("jsp/show");
		return model;
	}
	/**
	 * 页面跳转到petshop
	 * @param session
	 * @return
	 */
	@RequestMapping("toPetshop")
	public ModelAndView toPetshop(HttpSession session) {
		session.setAttribute("operateStatus", 3);
		return petService.retrievePetByPetType(0,0);
	}
	/**
	 * 按key查询宠物分页
	 * @param petypeId
	 * @param adoptStatus
	 * @return
	 */
	@RequestMapping("doRetrievePetByKey")
	public ModelAndView toRetrievePetByPetType(Integer petypeId,Integer adoptStatus) {
		return petService.retrievePetByPetType(petypeId,adoptStatus); 
	}
	/**
	 * 领养功能实现
	 * @param masterId
	 * @param petId
	 * @return
	 */
	@RequestMapping("/user/doAdoptPet")
	public ModelAndView toAdoptPet(Integer masterId,Integer petId) {
		
		return petService.adoptPet(masterId,petId);
	}
	
	/*******************************petType***************************************/
	
	@RequestMapping("/admin/doCreatePetType")
	public ModelAndView doCreatePetType(PetType petType) {
		petService.createPetType(petType);
		return petService.retrievePet();
	}
	
	public ModelAndView doDeletePetType() {
		return null;	
	}
	
	public ModelAndView doUpdatePetType() {
		return null;
	}
	
	public ModelAndView doretrieveAllPetType() {
		return null;
	}
	
	public ModelAndView doRetrievePetTypePage() {
		return null;
	}
}
