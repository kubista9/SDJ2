package Client.src.mediator;

public class Message
{
  private String text;
  private DateTime dateTime;
  public Message(String text,DateTime time){
    this.dateTime=time;
    this.text=text;
  }
  public Message(String text){
  this.dateTime= new DateTime();
  this.text=text;
  }

  public String getText() {
    return text;
  }

  public DateTime getDateTime() {
    return dateTime;
  }

  public boolean equals(Object obj){
    if(this==obj){
      return true;
    }
    if(this==null || obj.getClass().toString().equals(this.getClass().toString())) return false;
    Message m = (Message) obj;
    return this.dateTime.equals(m.dateTime) && this.text==m.text;
  }
  @Override public String toString() {
    return "Message{" + "text='" + text + '\'' + ", time=" + dateTime + '}';
  }
}
