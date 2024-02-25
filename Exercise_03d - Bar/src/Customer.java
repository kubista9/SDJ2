public class Customer implements Runnable{
	private Bar bar;
	private int beersToDrink;

	public Customer(Bar bar, int beersToDrink) {
		this.bar = bar;
		this.beersToDrink = beersToDrink;
	}

	public void run(){
		while (true){
			bar.takeBeer();
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
