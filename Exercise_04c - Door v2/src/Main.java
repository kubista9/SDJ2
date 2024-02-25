public class Main {
	public static void main(String[] args) {

		Door door = new Door();
		System.out.println("Start up, the door is " + door.status());

		door.click();
		System.out.println("Clicked, the door is" + door.status());

		door.click();
		System.out.println("Clicked, the door is" + door.status());

		door.click();
		System.out.println("Clicked, the door is" + door.status());
	}
}
