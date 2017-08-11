package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import model.User;
import model.UserType;

public class DaoUserImp implements DaoUser {

	private ConnectionManager connection;

	public DaoUserImp()  {
		try {
			this.connection = new ConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void delete(User user) {

		try {
			Connection conn = connection.connection();

			String sql = "DELETE FROM librarytest.user WHERE iduser = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getIdUser());

			statement.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public List<User> searchAll() {
		List<User> returnList = new ArrayList<>();

		try {
			Connection conn = connection.connection();

			String sql = "SELECT iduser, email, name, password, birthDate, address, idusertype, phoneNumber FROM user";

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setIdUser(resultSet.getInt("iduser"));
				user.setEmail(resultSet.getString("email"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setBirthDate(resultSet.getDate("birthDate"));
				user.setAddress(resultSet.getString("address"));
				int idUserType = resultSet.getInt("idusertype");
				if (UserType.ADM.getUserType() == idUserType) {
					user.setUserType(UserType.ADM);
				} else if (UserType.NORMAL.getUserType() == idUserType) {
					user.setUserType(UserType.NORMAL);
				}
				user.setPhoneNumber(resultSet.getString("phoneNumber"));

				returnList.add(user);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}

	public void save(User user) {
		try {

			Connection conn = connection.connection();

			String sql = "INSERT INTO user (idusertype, email, password, name, address, birthDate, phoneNumber)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getUserType().getUserType());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getName());
			statement.setString(5, user.getAddress());
			statement.setDate(6,  new Date(user.getBirthDate().getTime()));
			statement.setString(7, user.getPhoneNumber());

			statement.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public User authenticateUser(String email, String password) {
		User user = null;
		try {
			Connection conn = connection.connection();

			String sql = "SELECT iduser, email, name, password, birthDate, address, idusertype, phoneNumber "
					+ "FROM librarytest.user Where email = ? AND password = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setIdUser(resultSet.getInt("iduser"));
				user.setEmail(resultSet.getString("email"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setBirthDate(resultSet.getDate("birthDate"));
				user.setAddress(resultSet.getString("address"));
				int idUserType = resultSet.getInt("idusertype");
				if (UserType.ADM.getUserType() == idUserType) {
					user.setUserType(UserType.ADM);
				} else if (UserType.NORMAL.getUserType() == idUserType) {
					user.setUserType(UserType.NORMAL);
				}
				user.setPhoneNumber(resultSet.getString("phoneNumber"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void update(User user) {
		try {

			Connection conn = connection.connection();

			String sql = "UPDATE librarytest.user "
					+ "	SET  email = ?, name = ?, password = ?, birthDate = ?, address = ?, phoneNumber = ? WHERE iduser = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setDate(4, new Date(user.getBirthDate().getTime()));
			preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setInt(7, user.getIdUser());

			preparedStatement.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
