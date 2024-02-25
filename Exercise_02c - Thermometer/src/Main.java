public class Main {
	public static void main(String[] args) {
		Thermometer thermometer = new Thermometer("t1", 15);

		Thread t1 = new Thread(thermometer, "Thermometer 1");
		t1.run();
	}
}
