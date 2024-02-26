package mediatorServer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
  private LocalDateTime time;
  public DateTime(){
    this.time = LocalDateTime.now();
  }
  public DateTime(LocalDateTime time){
    this.time = time;
  }
  public String getTimestamp(){
    DateTimeFormatter dtf;
    dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return time.format(dtf);
  }
  public String getSortableDate(){
    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return time.format(dtf);
  }
  public boolean equals(Object obj){
    if(this==obj){
      return true;
    }
    if(this==null || obj.getClass().toString().equals(this.getClass().toString())) return false;
    DateTime d = (DateTime) obj;
    return this.time.equals(d.time);
  }

  @Override public String toString(){
    return getTimestamp();
  }
}