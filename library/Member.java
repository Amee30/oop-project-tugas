
class Member extends Borrow{
  private final String name;
  private final String id;

  protected Member(String name, String id){
    this.id = id;
    this.name = name;
  }

  public String name(){
    return name;
  }

  public String id(){
    return id;
  }
}