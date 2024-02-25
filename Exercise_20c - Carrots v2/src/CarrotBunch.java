import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class CarrotBunch {
	private QueueADT<Carrot> carrots;
	private int whenToStartPeeling;
	private int whenToStopPeeling;

	public CarrotBunch(int start, int stop, int maxCarrots) {
		this.whenToStartPeeling = start;
		this.whenToStopPeeling = stop;
		this.carrots = new BoundedArrayQueue<>(maxCarrots);
	}

	public synchronized void peel(CarrotBunch carrots) {
		if (this.carrots.size() >= whenToStartPeeling) {
			while (this.carrots.size() <= 20) {
				this.carrots.enqueue(new Carrot());
				try {
					wait(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println("Carrot is peeled");
			}
		} else {
			try {
				wait(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public synchronized void eat() {
		while (carrots.size() > 0) {
			carrots.dequeue();
			try {
				wait(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Eating....");
		}
	}

	public int getSize() {
		return carrots.size();
	}

	public synchronized void put(Carrot carrot) {
		if (isFull()) {
			try {
				wait();
			} catch (IllegalArgumentException | InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		carrots.enqueue(carrot);
		notifyAll();
	}

	public synchronized Carrot take() {
		if (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		notifyAll();
		return carrots.dequeue();
	}

	public synchronized Carrot look() {
		if (isEmpty()) {
			return null;
		} else {
			return carrots.first();
		}
	}

	public synchronized boolean isEmpty() {
		return carrots.isEmpty();
	}

	public synchronized boolean isFull() {
		return carrots.isFull();
	}

	public synchronized int size() {
		return carrots.size();
	}
}
