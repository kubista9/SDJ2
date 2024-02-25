import java.util.ArrayDeque;
import java.util.Queue;

public class ReadWriteFair {
	private int readers;
	private int writers;
	private Queue<Thread> queue;

	public ReadWriteFair() {
		readers = 0;
		writers = 0;
		queue = new ArrayDeque<>();
	}

	public synchronized void acquireRead() {
		queue.offer(Thread.currentThread());
		while (queue.peek() != Thread.currentThread()) {
			wait();
		}
		while (writers > 0) {
			wait();
		}
		readers++;
		queue.remove();
		notifyAll();
	}

	public synchronized void releaseRead() {
		readers--;
		if (readers == 0) {
			notifyAll();
		}
	}

	public synchronized void acquireWrite() {
		queue.offer(Thread.currentThread());
		while (queue.peek() != Thread.currentThread()) {
			wait();
		}
		while (readers > 0 || writers > 0) {
			wait();
		}
		writers++;
		queue.remove();
	}

	public synchronized void releaseWrite() {
		writers--;
		notifyAll();
	}
}
