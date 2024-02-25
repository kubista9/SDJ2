public class Counter {
	private long value, max, min;

	public Counter (long min, long max){
		this.min = max;
		this.max = max;
		this.value = 0;
	}

	public synchronized void increment(){
		if(value >= max){
			try {
				wait();
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		value++;
		System.out.println(Thread.currentThread().getName());
	}

	public synchronized void decrement(){
		if(value <= min){
			System.out.println(Thread.currentThread().getName());
			try {
				wait();
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		value--;
		System.out.println(Thread.currentThread().getName());
	}

	public synchronized long getValue(){
		return value;
	}




}
