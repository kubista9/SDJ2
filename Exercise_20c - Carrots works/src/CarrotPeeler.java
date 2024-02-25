import javax.swing.text.html.HTML;

public class CarrotPeeler implements Runnable {

	private BlockingQueue<Carrot> carrots;

	public CarrotPeeler(BlockingQueue<Carrot> carrots) {
		this.carrots = carrots;
	}

	@Override
	public void run() {
		while (true){
			if (carrots.size() >= 20){
				try {
					Thread.sleep(3000);
					System.out.println("Peeler is waiting");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			else {
				carrots.put(new Carrot());
				System.out.println("New carrot");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
