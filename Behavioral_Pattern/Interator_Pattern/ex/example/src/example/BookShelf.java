package example;

public class BookShelf {
	private Book[] books;
	private int last=0;
	public BookShelf(int maxsize) {
		
	}
	public Book getBookAt(int index) {
		return books[index];		
	}
}
