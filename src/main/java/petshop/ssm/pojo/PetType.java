package petshop.ssm.pojo;

public class PetType {

	private Integer id;
	private String typeName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "PetType [id=" + id + ", typeName=" + typeName + "]";
	}
	
}
