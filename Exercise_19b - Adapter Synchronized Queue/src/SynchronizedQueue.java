import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class SynchronizedQueue<T> implements Buffer<T> {
	private QueueADT<T> queue;
	public SynchronizedQueue(int capacity){
		this.queue = new BoundedArrayQueue<>(capacity);
	}

	@Override
	public synchronized void put(T element) {
		queue.enqueue(element);
	}
	@Override
	public synchronized T take() {
		return queue.dequeue();
	}
	@Override
	public synchronized T lock() {
		return queue.first();
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

	public String toString(){
		return "Queue: " + queue;
	}
}
