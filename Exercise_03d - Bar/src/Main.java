public class Main {
	public static void main(String[] args) {
		Bar bar = new Bar(20);

		Thread[] bartenders = new Thread[5];
		for(int i = 0; i < bartenders.length; i++){
			Bartender bartender = new Bartender(bar);
			bartenders[i] = new Thread(bartender);
			bartenders[i].start();
		}

		Thread[] customers = new Thread[7];
		for(int i = 0; i < customers.length; i++){
			Customer customer = new Customer(bar, 1);
			customers[i] = new Thread(customer);
			customers[i].setDaemon(true);
			customers[i].start();
		}


		for (int i = 0; i < customers.length; i++){
			try{
				customers[i].join();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
