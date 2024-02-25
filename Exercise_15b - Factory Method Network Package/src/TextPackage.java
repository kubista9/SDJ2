public class TextPackage extends NetworkPackage{
	private String text;
	public TextPackage(String type, String text){
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
