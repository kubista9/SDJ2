package Client.src.mediator;

public class NetworkPackage
{
  private String type;

  public NetworkPackage(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public boolean equals(Object obj){
    if(this==obj){
      return true;
    }
    if(this==null || obj.getClass().toString().equals(this.getClass().toString())) return false;
    NetworkPackage d = (NetworkPackage) obj;
    return this.type.equals(d.type);
  }

  @Override public String toString(){
    return getType();
  }
}
