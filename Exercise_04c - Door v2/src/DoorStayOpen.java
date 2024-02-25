public class DoorStayOpen extends DoorState {
	private Thread motor;
	private boolean completed;

	public DoorStayOpen(Door door) {
		completed = false;
		motor = new Thread(() -> {
			try {
				Thread.sleep(5000);
				complete(door);
			} catch (InterruptedException e) {
				System.out.println("Motor interrupted (closing)");
			}
		});
		motor.start();
	}

	@Override
	public synchronized void click(Door door) {
		if (!completed) {
			motor.interrupt();
			door.setState(new DoorClosing(door));
			completed = true;
		}
	}
}
