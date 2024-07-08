package internaltest1;

import java.util.Scanner;

public class Mainclass1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] books = new Book[4];
		// System.out.println("Book Id:");
		// String bId=sc.next();
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter details for Book " + (i + 1) + ":");
			System.out.println("Name of the book:");
			String bName = sc.nextLine();
			System.out.println("Cost of the book:");
			int bCost = sc.nextInt();
			System.out.println("Pages of the book:");
			int bPages = sc.nextInt();
			System.out.println("Name of the Author:");
			sc.nextLine();
			String aName = sc.nextLine();
			System.out.println("--------------Book" + (i + 1) + "Details---------------");
			books[i] = new Book(bName, bCost, bPages, aName);
			books[i].display();
			System.out.println();
		}
		boolean status = true;
		while (status) {
			System.out.println("Are there any changes you want to do? (y/n):");
			char opinion = sc.next().charAt(0);
			if (opinion == 'n' || opinion == 'N') {
				break;
			} else {
				System.out.println("Enter the book number you want to change (1-4):");
				int bookNumber = sc.nextInt() - 1;
				if (bookNumber < 0 || bookNumber >= 4) {
					System.out.println("Invalid book number");
					continue;
				}
				Book book = books[bookNumber];
				System.out.println("Enter the option number you want to change:");
				System.out.println(
						"1.Update Book Title\n2.Update Book Cost\n3.Update Book Pages\n4.Update Author Name\n5.Exit");
				char n = sc.next().charAt(0);
				switch (n) {
				/*
				 * case '1':System.out.println("Enter New BookId:"); String bookId=sc.next();
				 * book1.updateBookId(bookId,); book1.display(); break;
				 */
				case '1':
					System.out.println("Enter New Title Book:");
					String bookTitle = sc.nextLine();
					book.updateBookTitle(bookTitle);
					book.display();
					break;
				case '2':
					System.out.println("Enter New Cost of Book:");
					int bookCost = sc.nextInt();
					book.updateCost(bookCost);
					book.display();
					break;
				case '3':
					System.out.println("Enter New No of Book Pages:");
					int bookPages = sc.nextInt();
					book.updatePages(bookPages);
					book.display();
					break;
				case '4':
					System.out.println("Enter New Author Name of Book:");
					sc.nextLine();
					String bookAuthor = sc.nextLine();
					book.updateAuthorName(bookAuthor);
					book.display();
					break;
				case '5':
					status = false;
					break;
				default:
					System.out.println("Invalid Update Option");
				}
			}
		}

	}
}
