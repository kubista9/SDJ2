public class Main {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue(10);

		Thread t1 = new Thread(()->{
			while(true){
				queue.put("Item");
				System.out.println(queue.toString());
			}
		});

		Thread t2 = new Thread(()->{
			while (true){
				queue.take();
				System.out.println(queue.toString());
			}
		});

		t1.start();
		t2.start();

	}
}
