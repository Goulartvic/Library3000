package dao;


public abstract class DaoFactory {

	private static DaoUser userDao;

	public static DaoUser getUserDao() {
		if (userDao == null) {
			userDao = new DaoUserImp();
		}
		return userDao;
	}
	
	private static DaoBook bookDao;
	public static DaoBook getBookDao() {
		if (bookDao == null) {
			bookDao = new DaoBookImp();
		}
		return bookDao;
	}
	
}
