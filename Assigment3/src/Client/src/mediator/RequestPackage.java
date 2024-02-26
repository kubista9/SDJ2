package Client.src.mediator;

public class RequestPackage extends NetworkPackage
{
  private String text;
  public RequestPackage(String type,String text){
    super(type);
    this.text=text;
  }

  public String getText() {
    return text;
  }
  public boolean equals(Object obj){
    if(this==obj){
      return true;
    }
    if(this==null || obj.getClass().toString().equals(this.getClass().toString())) return false;
    RequestPackage rp = (RequestPackage) obj;
    return super.equals(rp) && this.text.equals(rp.getText());
  }

  @Override public String toString() {
    return super.toString() + " RequestPackage{" + "value=" + text + '}';
  }
}
