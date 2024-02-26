package mediatorServer;

public class RequestPackage extends NetworkPackage{

	private String text;
	public RequestPackage(String type, String text){
		super(type);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String toString(){
		return "Text: " + text;
	}
}
