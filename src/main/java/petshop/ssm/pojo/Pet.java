package petshop.ssm.pojo;

import java.util.Date;

public class Pet {

	private Integer id;
	private Integer health;
	private Integer love;
	private String petName;
	private Date addTime;
	private Date adoptTime;
	private Integer masterId;
	private Integer petTypeId;
	private String picPath;
	//一对一关系
	private Master master;
	private PetType petType;
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public Integer getPetTypeId() {
		return petTypeId;
	}
	public void setPetTypeId(Integer petTypeId) {
		this.petTypeId = petTypeId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public Integer getLove() {
		return love;
	}
	public void setLove(Integer love) {
		this.love = love;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getAdoptTime() {
		return adoptTime;
	}
	public void setAdoptTime(Date adoptTime) {
		this.adoptTime = adoptTime;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", health=" + health + ", love=" + love + ", petName=" + petName + ", addTime="
				+ addTime + ", adoptTime=" + adoptTime + ", master=" + master + ", petType=" + petType + "]";
	}
	
	
}
