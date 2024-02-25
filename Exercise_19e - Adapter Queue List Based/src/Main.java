import utility.collection.BoundedArrayQueue;
import utility.collection.CircularLinkedList;
import utility.collection.QueueADT;

import java.util.concurrent.SynchronousQueue;

public class Main {
	public static void main(String[] args) {
		QueueListBased queue = new QueueListBased();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		System.out.println(queue.toString());
		System.out.println(queue.size());
		System.out.println(queue.indexOf(3));
	}
}
