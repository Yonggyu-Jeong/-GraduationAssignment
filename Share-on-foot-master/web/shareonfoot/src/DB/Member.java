package DB;

public class Member {
	
	private String id;
	private String password;
	private String nickname;
	private String gender;
	private String birth;
	
	
	public Member() {
		super();
	}
		
	public Member(String id, String password, String nickname, String gender, String birth) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
