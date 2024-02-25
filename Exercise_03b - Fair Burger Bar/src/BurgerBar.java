public class BurgerBar {
	private int numberOfBurgers, maxNumberOfBurgers, nextNumberToTake, nextNumberToServe;

	public BurgerBar(int maxNumberOfBurgers) {
		this.maxNumberOfBurgers = maxNumberOfBurgers;
		this.numberOfBurgers = 0;
		this.nextNumberToTake = 1;
		this.nextNumberToServe = 1;
	}

	public synchronized void makeABurger(String employeeName){
		while (numberOfBurgers >= maxNumberOfBurgers)
		{
			try
			{
				System.out.println(employeeName + " is waiting to create a burger. Total: " + numberOfBurgers);
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		numberOfBurgers++;
		System.out.println(employeeName + " created a burger. Total: " + numberOfBurgers);
		notifyAll();
	}


	public synchronized void eatABurger(String who){
		int myNumber = nextNumberToTake;
		while ( numberOfBurgers <= 0 || myNumber != nextNumberToServe) {
			try {
				System.out.println(who + " is waiting for a burger. Total: " + numberOfBurgers);
				wait();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		numberOfBurgers--;
		nextNumberToServe++;
		System.out.println(who + " is eating a burger. Total: " + numberOfBurgers);
		notify();
	}

	public synchronized int getNumberOfBurgers(){
		return numberOfBurgers;
	}
}
