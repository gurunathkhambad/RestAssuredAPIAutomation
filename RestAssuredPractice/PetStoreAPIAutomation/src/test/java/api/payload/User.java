package api.payload;

public class User {

	  String id;
	  String username;
	  String firstName;
	  String lastName;
	  String email;
	  String password;
	  String phone;
  int userStatus=0;
  
   int IdNo;
   int phNo;
  public int getPhNo() {
	return phNo;
}
public void setPhNo(int phNo) {
	this.phNo = phNo;
}
public int getIdNo() {
	return IdNo;
}
public void setIdNo(int idNo) {
	IdNo = idNo;
}
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
