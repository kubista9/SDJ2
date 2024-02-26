package Client.src.mediator;

public class MessagePackage extends NetworkPackage
{
  private Message message;
  public MessagePackage(String type, Message message)
  {
    super(type);
    this.message = message;
  }

  public Message getMessage() {
    return message;
  }

  public boolean equals(Object obj){
    if(this==obj){
      return true;
    }
    if(this==null || obj.getClass().toString().equals(this.getClass().toString())) return false;
    MessagePackage mp = (MessagePackage) obj;
    return super.equals(mp) && this.message.equals(mp.message);
  }

  @Override public String toString() {
    return super.toString() + " MessagePackage{" + "message=" + message.toString() + '}';
  }
}
