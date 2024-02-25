public class Main {
	public static void main(String[] args) {
		Toilet toiletBuilding = new Toilet(5);

		Thread[] personThreads = new Thread[9];

		for (int i = 0; i < personThreads.length; i++) {
			Person person = new Person("Person" + (i + 1), toiletBuilding);
			personThreads[i] = new Thread(person);
			personThreads[i].start();
		}

		for (int i = 0; i < personThreads.length; i++) {
			try {
				personThreads[i].join();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
