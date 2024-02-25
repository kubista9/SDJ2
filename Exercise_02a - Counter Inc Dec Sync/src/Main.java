public class Main {
	public static void main(String[] args) {

		Counter counter = new Counter(1, 10);

		CounterIncrement increment1 = new CounterIncrement(200, counter);
		CounterIncrement increment2 = new CounterIncrement(200, counter);

		CounterDecrement decrement1 = new CounterDecrement(200, counter);
		CounterDecrement decrement2 = new CounterDecrement(200, counter);

		Thread t1 = new Thread (increment1, "Increment 1");
		Thread t2 = new Thread (increment2, "Increment 2");

		Thread t3 = new Thread (decrement1, "Decrement 1");
		Thread t4 = new Thread (decrement2, "Decrement 2");

		t1.start();
		t2.start();

		t3.start();
		t4.start();

		System.out.println("value:" + counter.getValue() + ": " + Thread.currentThread().getName());
	}
}
