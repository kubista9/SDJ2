public class ToiletBuilding implements PublicToilet{
	//writer preference
	//people readers
	//cleaning person writes

	private int cleaners;
	private int persons;
	private int waitingCleaners;

	public ToiletBuilding(int cleaners, int persons){
		this.cleaners = cleaners;
		this.persons = persons;
		this.waitingCleaners = 0;
	}

	@Override
	public synchronized void stepIntoCabin(int value) {
		while (cleaners > 0 || waitingCleaners > 0){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Step into cabin");
		spendSomeTime(2500);
	}

	@Override
	public synchronized void leaveCabin() {
		persons--;
		if (persons == 0){
			notify();
		}
		System.out.println("Leave cabin");
	}

	@Override
	public synchronized void startCleaning() {
		waitingCleaners++;
		while(persons > 0 || cleaners > 0){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Start cleaning");
		spendSomeTime(4000);
		waitingCleaners--;
		cleaners++;
	}

	@Override
	public synchronized void endCleaning() {
		cleaners--;
		notifyAll();
		System.out.println("End cleaning");
	}

	public void spendSomeTime(int seconds) {
		try {
			wait(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
