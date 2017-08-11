package control;

import java.util.List;

import model.User;
import dao.DaoUser;
import dao.DaoUserImp;


public class UserControl {
	
	private DaoUser userDao;
	
	public UserControl(){

			this.userDao = new DaoUserImp();

	}
	
	public void save(User user) throws Exception {
		if (user.getName() == null || user.getName().trim().isEmpty()) {
			throw new Exception("The name is required");
		}

		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			throw new Exception("The email is required");
		}
		if (user.getBirthDate() == null) {
			throw new Exception("The birth date is required");
		}
		
		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			throw new Exception("The password is required");
		}
		if (user.getAddress() == null || user.getAddress().trim().isEmpty()) {
			throw new Exception("The address is required");
		}
		
		if (user.getUserType() == null) {
			throw new Exception("The user type is required");
		}

			userDao.save(user);

	}

	public void update(User user) throws Exception{
		if (user == null){
			throw new Exception(
					"You need to choose one user to update"
			);
		}
		userDao.update(user);
	}
	public List<User> searchAll() {
		return userDao.searchAll();
	}

	public void delete(User user) throws Exception {
		if (user == null) {
			throw new Exception(
					"You need to choose one user to remove");
		}
		userDao.delete(user);
	}

	public User authenticateUser(String email, String password) {
		return userDao.authenticateUser(email, password);
	}
}
