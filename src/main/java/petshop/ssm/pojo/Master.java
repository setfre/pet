package petshop.ssm.pojo;

public class Master {

	private Integer id;
	private String username;//昵称
	private String loginId; //用户名
	private String loginPwd;//用户密码
	private Integer roleId; //角色id
	private Role role;		//状态
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
