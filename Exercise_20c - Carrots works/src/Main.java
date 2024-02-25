public class Main {
	public static void main(String[] args) {
		BlockingQueue<Carrot> carrots = new BlockingQueue<>(20);

		CarrotPeeler peeler = new CarrotPeeler(carrots);
		Thread t1 = new Thread(peeler);
		t1.start();

		Thread t2 = new Thread(()->{
			while (true){
				CarrotEater eater = new CarrotEater(carrots);
				eater.run();
				System.out.println(carrots.toString());
			}
		});

		t2.start();

	}
}
