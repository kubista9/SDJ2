public class Phone {
	private AlertState alertState = new SilentState();

	public void clickSoundButton(){
		alertState.click(this);
	}

	public void setState(AlertState state){
		this.alertState = state;
	}

	public String receive(String message){
		String alert = alertState.alert();
		return "Alert: " + alert + " Message " + message;
	}
}


