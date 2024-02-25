package client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Message{
	private String id;
	private String messageBody;
	private String dateTime;
	public Message(String id, String message){
		this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss"));
		this.id = id;
		this.messageBody = message;
	}

	public Message(String message){
		this("0", message);
		setId("" + (int) (messageBody.hashCode() * Math.random()));
	}

	public Message update(){
		this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss"));
		return this;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getBody(){
		return messageBody;
	}

	public String getDateTime(){
		return dateTime;
	}

	public String toString(){
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
		return "id=" + id + ", time=" + dateTime+ ", message=\"" + messageBody + "\"";
	}
}
