public abstract class NetworkPackage {
	private String type;
	public NetworkPackage(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String toString(){
		return "Type: " + type;
	}
}
