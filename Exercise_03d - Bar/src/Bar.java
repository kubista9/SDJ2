import java.util.ArrayList;

public class Bar {
	private int amountOfBeers;
	public Bar(int amountOfBeers) {
		this.amountOfBeers = amountOfBeers;
	}

	public synchronized void placeBeer(){
		if (amountOfBeers < 20){
			amountOfBeers++;
			System.out.println("A beer is placed");
			try {
				wait(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			try {
				wait(2500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		notifyAll();
	}

	public synchronized void takeBeer(){
		if (amountOfBeers > 0){
			amountOfBeers--;
			System.out.println("A beer is taken");
			try {
				wait(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			try {
				wait(4000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		notifyAll();
	}
}
