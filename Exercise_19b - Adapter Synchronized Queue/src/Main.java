public class Main {
	public static void main(String[] args) {
		SynchronizedQueue queue = new SynchronizedQueue(10);
		queue.put("first element");
		queue.put("second element");
		queue.put("third element");
		queue.put("fourth element");
		System.out.println(queue.toString());
	}
}
