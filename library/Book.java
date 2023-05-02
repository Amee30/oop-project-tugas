class Book {
  private final String id;
  private final String title;

  public Book(String title, String id){
    this.title = title;
    this.id = id;
  }


  public String title(){
    return title;
  }

  public String id(){
    return id;
  }
}