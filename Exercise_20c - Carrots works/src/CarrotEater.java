public class CarrotEater implements Runnable{
	private BlockingQueue<Carrot> carrots;

	public CarrotEater(BlockingQueue<Carrot> carrots) {
		this.carrots = carrots;
	}

	@Override
	public void run() {
		while (true){
			if (carrots.size() > 0){
				carrots.take();
				System.out.println("Carrot was eaten");
				System.out.println("Number of carrots");
				try {
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			else{
				try {
					Thread.sleep(3000);
					System.out.println("Eater is waiting");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
