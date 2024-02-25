public class Main {
	public static void main(String[] args) {
		ThreadSafeLinkedList list = new ThreadSafeLinkedList(1);
		list.add("First element");
		list.add("Second element");
		list.add("Third element");
		list.add("Fourth element");

		System.out.println("Size: " + list.size());
		list.remove(2);
		System.out.println("Size: " + list.size());
	}
}
