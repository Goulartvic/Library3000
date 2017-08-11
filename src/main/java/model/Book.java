package model;


public class Book {
	
	private int idBook;
	
	private String title;
	
	private String editor;
	
	private short yearPubli;
	
	private String writer;
	
	private String edition;
	
	private BookStatus bookStatus;

	public Book(String title, String editor, short yearPubli, String writer, String edition){
		this.title = title;
		this.editor = editor;
		this.yearPubli = yearPubli;
		this.writer = writer;
		this.edition = edition;
		this.bookStatus = BookStatus.AVAILABLE;
	}
	
	public Book(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public short getYearPubli() {
		return yearPubli;
	}

	public void setYearPubli(short yearPubli) {
		this.yearPubli = yearPubli;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getIdBook() {
		return idBook;
	}
	
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}


}
