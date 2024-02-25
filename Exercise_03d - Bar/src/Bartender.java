public class Bartender implements Runnable {
	private Bar bar;
	public Bartender(Bar bar) {
		this.bar = bar;
	}

	public void run() {
		while (true){
			bar.placeBeer();
			try{
				Thread.sleep(5000);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
