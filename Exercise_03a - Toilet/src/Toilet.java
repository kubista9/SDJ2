public class Toilet implements PublicToilet{
	private int numberOfCabins;

	public Toilet(int numberOfCabins) {
		this.numberOfCabins = numberOfCabins;
	}

	@Override
	public synchronized void stepIntoCabin() {
		while (numberOfCabins > 0 && numberOfCabins < 5){
			try{
				System.out.println("Bathroom is being used....");
				Thread.sleep(6000);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		numberOfCabins--;
		System.out.println("Number of available cabins is: " + numberOfCabins);
	}

	@Override
	public synchronized void leaveCabin() {
		while (numberOfCabins > 0 && numberOfCabins < 5){
			try{
				wait(2000);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		numberOfCabins++;
		System.out.println("One cabin is free\n" + "Number of available cabins is: " + numberOfCabins);
		notifyAll();
	}
}
