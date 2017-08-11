package dao;

import java.util.List;

import model.Book;

public interface DaoBook extends DAO<Book>{
	
	List<Book> searchByTitle(String title);
	List<Book> searchByWriter(String writer);
	List<Book> searchAll();
}
