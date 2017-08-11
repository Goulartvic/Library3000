package model;


import java.util.Date;

public class User {
	
	private Integer idUser;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private Date birthDate = new Date();
	
	private String address;
	
	private UserType userType;

    private String phoneNumber;

	public User(String email, String password, String name, Date birthDate, String address, UserType userType, String phoneNumber){
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.userType = userType;
		this.phoneNumber = phoneNumber;
	}
	
	public User(){
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
	
}
