public class DoorOpen extends DoorState {
	private Thread motor;
	private boolean completed;

	public DoorOpen(Door door) {
		completed = false;
		motor = new Thread(() -> {
			try {
				Thread.sleep(5000);
				complete(door);
			} catch (InterruptedException e) {
				System.out.println("Motor interrupted(open)");
			}
		});
		motor.start();
	}

	public synchronized void complete(Door door) {
		if (!completed) {
			System.out.println("Motor ended (closing)");
			door.setState(new DoorClosing(door));
			completed = true;
		}
	}

	@Override
	public synchronized void click(Door door) {
		if (!completed) {
			motor.interrupt();
			door.setState(new DoorStayOpen(door));
			completed = true;
		}
	}
}
