public class ConsoleLogger implements Logger {
	public ConsoleLogger() {}

	public void log(String txt) {
		System.out.println(txt);
	}
}
