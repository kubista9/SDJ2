public class CounterIncrement implements Runnable {
	private int updates;
	private Counter counter;

	public CounterIncrement(int updates, Counter counter) {
		this.updates = updates;
		this.counter = counter;
	}

	public void run(){
		for (int i = 0; i < updates; i++){
			counter.increment();
		}
		System.out.println("Value of the counter: " + counter.getValue());
	}
}
