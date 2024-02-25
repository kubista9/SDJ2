public class Phone {
	private AlertState alertState;
	private int volume;
	private static final int MIN_VOLUME = 0;
	private static final int MAX_VOLUME = 10;

	public Phone(AlertState state){
		this.alertState = state;
	}
	public void clickSoundButton(){
		alertState.click(this);
	}
	public void setState(AlertState state){
		this.alertState = state;
	}
	public void volumeUp(){
		volume++;
	}
	public void volumeDown(){
		volume--;
	}
	public int getVolume(){
		return volume;
	}

	public String receive(String message){
		String alert = alertState.alert();
		return "Alert: " + alert + "Message" + message;
	}
}
