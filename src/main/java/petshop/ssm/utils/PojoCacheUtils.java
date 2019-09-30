package petshop.ssm.utils;

import java.util.ArrayList;
import java.util.List;

import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;
import petshop.ssm.pojo.Pet;
import petshop.ssm.pojo.PetType;
import petshop.ssm.pojo.Role;

public class PojoCacheUtils {

	//private static List<Master> users = new ArrayList<Master>();
	
	//private static List<Pet> pets = new ArrayList<Pet>();
	
	private static List<PetType> petTypes = new ArrayList<PetType>();
	
	private static List<Role> roles = new ArrayList<Role>();
	
	
	private Pagination<Master> users = new Pagination<Master>();
	public Pagination<Master> getUsersPagination() {
		return users;
	}
}
