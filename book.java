package internaltest1;

import java.util.Random;

class Book {
	private String bookId;
	private String bookTitle;
	private int bookCost;
	private int pages;
	private String bookAuthor;

	public Book(String bookTitle, int bookCost, int pages, String bookAuthor) {
		if (verifyBookTitle(bookTitle) && verifyBookCost(bookCost) && verifyPages(pages)
				&& verifyBookAuthor(bookAuthor)) {
			// this.bookId=bookId;
			this.bookTitle = bookTitle;
			this.bookCost = bookCost;
			this.pages = pages;
			this.bookAuthor = bookAuthor;

		} else
			System.err.println("Invalid data");
	}
	/*
	 * private boolean verifyBookId(String bookId,String bookTitle) { int
	 * ccount=0,dcount=0; bookId=generateBookId(bookId,bookTitle); for(int
	 * i=0;i<bookId.length();i++) { char ch=bookId.charAt(i);
	 * if(Character.isAlphabetic(ch)) ccount++; else if(Character.isDigit(ch))
	 * dcount++; } if(ccount==3&&dcount==3&&(ccount+dcount)==6) return true; else
	 * return false; }
	 */

	private String generateBookId(String bookId, String bookTitle) {
		if (bookId == null)
			bookId = "";
		for (int i = 0; i < 3; i++) {
			char ch = bookTitle.charAt(i);
			bookId += ch;
		}
		Random r1 = new Random();
		int r = r1.nextInt(999);
		bookId += r;
		return bookId;
	}

	private boolean verifyBookTitle(String bookTitle) {
		int acount = 0, dcount = 0, ucount = 0, scount = 0;

		for (int i = 0; i < bookTitle.length(); i++) {
			char ch = bookTitle.charAt(i);
			if (Character.isAlphabetic(ch))
				acount++;
			else if (Character.isDigit(ch))
				dcount++;
			else if (ch == ' ')
				scount++;
			else if (ch == '_')
				ucount++;
		}
		if (dcount >= 1 && acount >= 5 && ucount >= 1 && scount >= 0
				&& ((dcount + acount + ucount + scount) == bookTitle.length())) {
			return true;
		} else
			return false;
	}

	private boolean verifyBookCost(int bookCost) {
		if (bookCost >= 200 && bookCost <= 1000)
			return true;
		else
			return false;
	}

	private boolean verifyPages(int pages) {
		if (pages >= 100 && pages <= 400)
			return true;
		else
			return false;
	}

	private boolean verifyBookAuthor(String bookAuthor) {
		for (int i = 0; i < bookAuthor.length(); i++) {
			char ch = bookAuthor.charAt(i);
			if (!Character.isAlphabetic(ch) && ch != ' ') {
				return false;
			}
			if (!Character.isUpperCase(bookAuthor.charAt(0))) {
				return false;
			}
			if (ch == ' ') {
				if (!Character.isUpperCase(bookAuthor.charAt(i + 1)))
					return false;
			}
		}
		return true;
	}

	// display
	public void display() {
		System.out.println("Book Id:" + generateBookId(bookId, bookTitle));
		System.out.println("Book Cost:" + bookCost);
		System.out.println("Book pages:" + pages);
		System.out.println("Book Title:" + bookTitle);
		System.out.println("Book Author is:" + bookAuthor);
	}

	// Modify
	public void updateCost(int changeCost) {
		if (verifyBookCost(changeCost))
			this.bookCost = changeCost;
		else
			System.err.println("invalid cost Update");
	}

	public void updatePages(int updatedPages) {
		if (verifyPages(updatedPages))
			this.pages = updatedPages;
		else
			System.err.println("Invalid pages Update");
	}

	/*
	 * public void updateBookId(String newBookId,String bookTitle) {
	 * if(verifyBookId(newBookId,bookTitle)) this.bookId=newBookId; else
	 * System.err.println("Invalid id update"); }
	 */
	public void updateAuthorName(String updatedAuthor) {
		if (verifyBookAuthor(updatedAuthor))
			this.bookAuthor = updatedAuthor;
		else
			System.err.println("Invalid Author Name update");
	}

	public void updateBookTitle(String updateBookTitle) {
		if (verifyBookTitle(updateBookTitle)) {
			this.bookTitle = updateBookTitle;
			generateBookId(bookId, bookTitle);
		} else
			System.err.println("Invalid Book Title update");
	}

	// Display items
	public void displayUpdateCost() {
		System.out.println("Updated cost:" + bookCost);
	}

	public void displayUpdatedPages() {
		System.out.println("Updated Pages are:" + pages);
	}

	/*
	 * public void displayUpdatedBookId() {
	 * System.out.println("The updated Book Id is:"+bookId); }
	 */
	public void displayUpdatedAuthor() {
		System.out.println("The updated Book Author name is:" + bookAuthor);
	}

	public void displayUpdatedBookTitle() {
		System.out.println("The updated Book Title is:" + bookTitle);
	}
}
