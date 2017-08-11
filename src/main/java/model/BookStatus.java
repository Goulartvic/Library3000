package model;

public enum BookStatus {
	RESERVED(1), WITHDRAWN(2), AVAILABLE(3);
	
	private final int bookStatus;

	private BookStatus(int book) {
		this.bookStatus = book;
	}

	public int getBookStatus() {
		return bookStatus;
	}
}


