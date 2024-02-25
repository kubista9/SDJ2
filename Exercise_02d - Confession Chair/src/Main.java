public class Main {
	public static void main(String[] args) {
		ConfessionChair confessionChair = new ConfessionChair();

		Thread[] churchgoersThreads = new Thread[5];
		for (int i = 0; i < churchgoersThreads.length; i++) {
			Churchgoer churchgoer = new Churchgoer(confessionChair);
			churchgoersThreads[i] = new Thread(churchgoer, "Churchgoer" + i);
			churchgoersThreads[i].start();
		}
	}
}
