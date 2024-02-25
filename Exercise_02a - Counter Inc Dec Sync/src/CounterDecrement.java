public class CounterDecrement implements Runnable {
	private int updates;
	private Counter counter;

	public CounterDecrement(int updates, Counter counter) {
		this.updates = updates;
		this.counter = counter;
	}

	public void run(){
		for (int i = 0; i < updates; i++){
			counter.decrement();
		}
		System.out.println("Value of the counter: " + counter.getValue());
		Thread.currentThread().getName();
	}
}
