public class Main {
	public static void main(String[] args) {
		Bird bird = new Bird();
		BirdWatcher watcher = new BirdWatcher(bird);
		DeafBirdWatcher deafWatcher = new DeafBirdWatcher(bird);
		BlindBirdWatcher blindWatcher = new BlindBirdWatcher(bird);

		bird.flashTheWings();
		bird.toWhistle();
	}
}
