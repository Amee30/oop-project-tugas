import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<>();
  public ArrayList<Member> members = new ArrayList<>();

  public void addMember(Member member, boolean duplicateCheck) {
    try{
      if (duplicateCheck) {
        isMemberIdExist(member.id());
      }

      this.members.add(member);

    }catch (LibraryException e){
      System.out.println("Member dengan ID ini Telah Terdaftar");
    }
  }

  public void isMemberIdExist(String id) throws LibraryException {
    for (Member member : this.members) {
      if (member.id().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void isBookIdExist(String id) throws LibraryException{
    for (Book book : this.books) {
      if (book.id().equals(id)) {
        throw new LibraryException();
      }
    }
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId, getBookList());
    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).receiveBook(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    if (member == null) {
      return;
    }

    Book book = this.getBookById(bookId, member.getBorrowList());
    this.books.add(book);

    this.members.get(memberIndex).giveBook(book);
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id().equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id, Book[] list) {
    for (Book book : list) {
      if (book != null && book.id().equals(id)) {
        return book;
      }
    }
    return null;
  }

  public void addBook(Book book, boolean duplicateCheck){
    try{
      if (duplicateCheck) {
        isBookIdExist(book.id());
      }
    }catch (LibraryException e){
      System.out.println("Buku dengan ID ini Sudah Terdaftar");
    }
    this.books.add(book);
  }

  public Member[] getMemList(){
    Member[] memberArray = new Member[this.members.size()];
    int i = 0;
    for (Member member : this.members) {
      memberArray[i++] = member;
    }
    return memberArray;
  }

  public void showMem(){
    for (Member member : getMemList()) {
      if (member == null) {
        continue;
      }
      System.out.printf("%s %s \n", member.id(), member.name());
    }
  }

  public void showBooks(){
    for (Book book : getBookList()) {
      if (book == null) {
        continue;
      }
      System.out.printf("%s %s \n", book.id(), book.title());
    }
  }

  public Book[] getBookList(){
    Book[] bookArray = new Book[this.books.size()];
    int i = 0;
    for (Book book : this.books) {
      bookArray[i++] = book;
    }
    return bookArray;
  }


}