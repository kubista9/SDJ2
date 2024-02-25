import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T> {
	private QueueADT<T> queue;

	public BlockingQueue(int capacity){
		this.queue = new BoundedArrayQueue(capacity);
	}

	public synchronized String toString(){
		return "Queue: " + queue;
	}

	@Override
	public synchronized void put(T element) {
		if (isFull()){
			try {
				wait();
			} catch (IllegalArgumentException | InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		queue.enqueue(element);
		notifyAll();
	}

	@Override
	public synchronized T take() {
		if (isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		notifyAll();
		return (T) queue.dequeue();
	}

	@Override
	public synchronized T look() {
		if (isEmpty()){
			return null;
		}
		else return queue.first();

	}

	@Override
	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return queue.isFull();
	}

	@Override
	public synchronized int size() {
		return queue.size();
	}
}
