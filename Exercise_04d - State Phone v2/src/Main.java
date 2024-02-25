public class Main {
	public static void main(String[] args) {

		Phone phone = new Phone(new SilentState());

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("Message 1"));

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("Message 2"));

		phone.volumeUp();
		System.out.println("Volume up clicked");
		System.out.println("Volume: " + phone.getVolume());
		phone.volumeUp();
		System.out.println("Volume up clicked");
		phone.volumeUp();
		System.out.println("Volume up clicked");
		phone.volumeUp();
		System.out.println("Volume up clicked");
		phone.volumeDown();
		System.out.println("Volume down clicked");
		System.out.println("Volume: " + phone.getVolume());

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("Message 3"));
	}
}
