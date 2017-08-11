package control;

import java.util.List;

import model.Book;
import dao.DaoBook;
import dao.DaoBookImp;

public class BookControl {

	private DaoBook bookDao;

	public BookControl() {

			this.bookDao = new DaoBookImp();

	}

	public void save(Book book) throws Exception {
		if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
			throw new Exception("The title is required");
		}

		if (book.getEditor() == null || book.getEditor().trim().isEmpty()) {
			throw new Exception("The editor is required");
		}

		if (book.getWriter() == null || book.getWriter().trim().isEmpty()) {
			throw new Exception("The wrtier name is required");
		}
		if (book.getEdition() == null || book.getEdition().trim().isEmpty()) {
			throw new Exception("The edition is required");
		}

		if (book.getIdBook() == 0) {
			bookDao.save(book);
		} else {
			bookDao.update(book);
		}
	}

	public List<Book> searchAll() {
		return bookDao.searchAll();
	}

	public List<Book> searchByTitle(String title) throws Exception {
		if (title == null || title.trim().isEmpty()) {
			throw new Exception("The title is required for the search");
		}
		return bookDao.searchByTitle(title);
	}

	public List<Book> searchByWriter(String writer) throws Exception {
		if (writer == null || writer.trim().isEmpty()) {
			throw new Exception("The writer name is required for the search");
		}
		return bookDao.searchByWriter(writer);
	}

	public void delete(Book book) throws Exception {
		if (book == null) {
			throw new Exception("You need to choose one user to remove");
		}
		bookDao.delete(book);
	}
}
