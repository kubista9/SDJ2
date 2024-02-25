import utility.collection.CircularLinkedList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

public class QueueListBased<T> implements QueueADT {
	private ListADT list;

	public QueueListBased() {
		this.list = new CircularLinkedList();
	}

	public String toString(){
		return "List: " + list;
	}

	@Override
	public synchronized void enqueue(Object element) {
		list.add(element);
	}

	@Override
	public synchronized Object dequeue() {
		return list.remove(0);
	}

	@Override
	public synchronized Object first() {
		return list.get(-1);
	}

	@Override
	public synchronized int indexOf(Object element) {
		return list.indexOf(element);
	}

	@Override
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return list.isFull();
	}

	@Override
	public synchronized int size() {
		return list.size();
	}

	@Override
	public synchronized int capacity() {
		return -1;
	}
}
