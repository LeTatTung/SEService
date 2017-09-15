package user;

public class User {
	private String username;
	private String password;
	private String uri;
	
	public User()
	{
	}
	
	public User(String username, String password, String uri) {
		this.username = username;
		this.password = password;
		this.uri = uri;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
