package br.com.neoway.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Book;
import control.BookControl;


@ManagedBean
@SessionScoped
public class BookBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Book book = new Book();
	private BookControl control = new BookControl();
	private Book selectedBook;
	private List<Book> books = new ArrayList<Book>();

	public Book getbook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Book> listSelectedBook(){
        return java.util.Arrays.asList(selectedBook);
    }

	public String cancelRegister() {
		return "bookList.xhtml";
	}

	public String saveBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			control.save(book);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Book registered successfully",
					""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "bookList.xhtml";

	}

	public String delete(Book bookPar) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			selectedBook = bookPar;
			control.delete(selectedBook);
			books.remove(selectedBook);
			selectedBook = null;
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Book deleted successfully", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "bookList.xhtml";
	}

	public String update(Book bookPar) {
        selectedBook = bookPar;
        return "updateBook.xhtml";
	}

	public String listAll() {
		books = control.searchAll();
		return "bookList.xhtml";
	}

	public String registerBook() {
		return "registerBook.xhtml";
	}

	public String updateBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			control.save(book);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "book updated successfully",
					""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		book = null;
		return "bookList.xhtml";
	}
	
	public String admCancel(){
		return "bookList.xhtml";
	}
	
	public String bookDetail(Book bookPar){
	    selectedBook = bookPar;
	    listSelectedBook();
		return "bookDetail.xhtml";
	}
	public String backToIndexUser(){
		return "indexUser.xhtml";
	}
}
