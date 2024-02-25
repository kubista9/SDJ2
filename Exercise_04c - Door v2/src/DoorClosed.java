public class DoorClosed extends DoorState {

	private Thread motor;
	private boolean completed;

	public DoorClosed(Door door) {
		completed = false;
		motor = new Thread(() -> {
			try {
				Thread.sleep(5000);
				complete(door);
			} catch (InterruptedException e) {
				System.out.println("Motor interrupted(closed)");
			}
		});
		motor.start();
	}

	@Override
	public synchronized void click(Door door) {
		if (!completed) {
			motor.interrupt();
			door.setState(new DoorOpening(door));
			completed = true;
		}
	}
}
