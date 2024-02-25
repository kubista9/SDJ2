import utility.collection.QueueADT;

public class Main {
	public static void main(String[] args) {
		CarrotBunch carrots = new CarrotBunch(4, 20, 40);

		CarrotPeeler peeler = new CarrotPeeler(carrots);
		CarrotEater eater = new CarrotEater(carrots);

		Thread t1 = new Thread(peeler);
		Thread t2 = new Thread(eater);
		t1.start();
		t2.start();


	}
}
