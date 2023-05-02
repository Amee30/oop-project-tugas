import java.util.ArrayList;

abstract class Borrow {
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public void receiveBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void giveBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public Book[] getBorrowList(){
        Book[] bookArray = new Book[borrowedBooks.size()];
        int i = 0;
        for (Book book : borrowedBooks) {
            bookArray[i++] = book;
        }
        return bookArray;
    }
}
