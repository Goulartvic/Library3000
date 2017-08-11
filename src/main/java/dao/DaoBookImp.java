package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import model.Book;

public class DaoBookImp implements DaoBook{
	
	private ConnectionManager connection;
	
    public DaoBookImp()  {
		try {
			this.connection = new ConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void save(Book book) {
		try {

        	Connection conn = connection.connection();
        	
            String sql = "INSERT INTO book (title, editor, yearPubli, writer, edition)" 
            		+ " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getEditor());
            statement.setShort(3, book.getYearPubli());
            statement.setString(4, book.getWriter());
            statement.setString(5, book.getEdition());
            
            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
		
	}

	@Override
	public void update(Book book) {
		try {

            Connection conn = connection.connection();

            String sql = "UPDATE librarytest.book "
                    + "	SET  title = ?, editor = ?, yearPubli = ?, writer = ?, edition = ? WHERE idbook = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getEditor());
            preparedStatement.setShort(3, book.getYearPubli());
            preparedStatement.setString(4, book.getWriter());
            preparedStatement.setString(5, book.getEdition());
            preparedStatement.setLong(6, book.getIdBook());

            preparedStatement.execute();
           
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

	@Override
	public void delete(Book book) {
		try {
			Connection conn = connection.connection();

			String sql = "DELETE FROM librarytest.book WHERE idbook = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, book.getIdBook());

			statement.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> returnList = new ArrayList<>();

		try {
			Connection conn = connection.connection();

			String sql = "SELECT title, editor, yearPubli, writer, edition, idbook FROM book WHERE title like ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			 statement.setString(1, '%' + title + '%');
			 
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setEditor(resultSet.getString("editor"));;
				book.setYearPubli(resultSet.getShort("yearPubli"));;
				book.setWriter(resultSet.getString("writer"));;
				book.setEdition(resultSet.getString("edition"));
				book.setIdBook(resultSet.getInt("idbook"));

				returnList.add(book);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}

	@Override
	public List<Book> searchByWriter(String writer) {
		List<Book> returnList = new ArrayList<>();

		try {
			Connection conn = connection.connection();

			String sql = "SELECT title, editor, yearPubli, writer, edition, idbook FROM book WHERE writer like ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			 statement.setString(1, '%' + writer + '%');
			 
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setEditor(resultSet.getString("editor"));;
				book.setYearPubli(resultSet.getShort("yearPubli"));;
				book.setWriter(resultSet.getString("writer"));;
				book.setEdition(resultSet.getString("edition"));
				book.setIdBook(resultSet.getInt("idbook"));

				returnList.add(book);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}

	@Override
	public List<Book> searchAll() {
		List<Book> returnList = new ArrayList<>();

		try {
			Connection conn = connection.connection();

			String sql = "SELECT idbook, title, editor, yearPubli, writer, edition FROM book";

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setIdBook(resultSet.getInt("idbook"));
				book.setTitle(resultSet.getString("title"));
				book.setEditor(resultSet.getString("editor"));;
				book.setYearPubli(resultSet.getShort("yearPubli"));;
				book.setWriter(resultSet.getString("writer"));;
				book.setEdition(resultSet.getString("edition"));
				book.setIdBook(resultSet.getInt("idbook"));

				returnList.add(book);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}
	
	
}
