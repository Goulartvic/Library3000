package model;

public enum UserType {
	NORMAL(1), ADM(2);

	private final int userType;

	private UserType(int user) {
		this.userType = user;
	}

	public int getUserType() {
		return userType;
	}
}
