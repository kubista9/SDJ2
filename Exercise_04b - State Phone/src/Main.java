public class Main {
	public static void main(String[] args) {
		Phone phone = new Phone();

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("OMG"));

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("WTF"));

		phone.clickSoundButton();
		System.out.println("Sound button is clicked " + phone.receive("LOL"));
	}
}
