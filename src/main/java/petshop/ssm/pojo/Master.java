package petshop.ssm.pojo;

public class Master {

	private Integer id;
	private String username;//�ǳ�
	private String loginId; //�û���
	private String loginPwd;//�û�����
	private Integer roleId; //��ɫid
	private Role role;		//״̬
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Master [id=" + id + ", username=" + username + ", loginId=" + loginId + ", loginPwd=" + loginPwd
				+ ", roleId=" + roleId + ", role=" + role + "]";
	}

}
