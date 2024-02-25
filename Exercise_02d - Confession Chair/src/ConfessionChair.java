public class ConfessionChair {
	private String sin;

	public synchronized void EnterConfessionBooth(String sin){
		while (this.sin != null){
			try {
				System.out.println(Thread.currentThread().getName() + ": waiting to enter");
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.sin = sin;
		System.out.println(Thread.currentThread().getName() + ": making a confession (" + sin + ")");
	}

	public synchronized int leaveConfessionBooth(){
		int penance = (int)(Math.random() * 10 + 1);
		System.out.println(Thread.currentThread().getName() + ": leaving with a penalty of " + penance + " Ave Maria (" + sin + ")");
		sin = null;
		notify();
		return penance;

	}
}
