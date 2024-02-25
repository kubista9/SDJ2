public class Churchgoer implements Runnable {
	private ConfessionChair confessionCHair;

	public Churchgoer(ConfessionChair confessionCHair) {
		this.confessionCHair = confessionCHair;
	}

	public void run() {
		String[] sins = {"I kicked a dog", "I did not make my SDJ exercises", "I laughed at my teacher", "I stole a cake", "I killed an ant"};
		for (int i = 0; i < 3; i++) {
			int sinNumber = (int) (Math.random() * sins.length);
			confessionCHair.EnterConfessionBooth(sins[sinNumber]);
			waiting(5);
			int penance = confessionCHair.leaveConfessionBooth();
			waiting(penance);
			System.out.println("-->" + Thread.currentThread().getName() + ": confession: " + sins[sinNumber] + ", penalty: " + penance);
		}
	}

	private void waiting(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
