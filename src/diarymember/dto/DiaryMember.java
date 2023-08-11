package diarymember.dto;

public class DiaryMember {
	
	private String diraryMemberId;
	private String password;
	private String name;

	public DiaryMember() {
		// TODO Auto-generated constructor stub
	}

	public DiaryMember(String diraryMemberId, String password, String name) {
		super();
		this.diraryMemberId = diraryMemberId;
		this.password = password;
		this.name = name;
	}

	public String getDiraryMemberId() {
		return diraryMemberId;
	}

	public void setDiraryMemberId(String diraryMemberId) {
		this.diraryMemberId = diraryMemberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DiaryMember [diraryMemberId=" + diraryMemberId + ", password=" + password + ", name=" + name + "]";
	}
	
}
