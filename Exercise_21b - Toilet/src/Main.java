public class Main {
	public static void main(String[] args) {
		PublicToilet sharedResource = new ToiletBuilding(2, 5);
		Thread[] persons = new Thread[30];
		for (int i = 0; i < persons.length; i++) {
			Person person = new Person(sharedResource);
			persons[i] = new Thread(person, "person" + i);
			persons[i].start();
		}
		Thread[] cleaners = new Thread[5];
		for (int i = 0; i < cleaners.length; i++) {
			CleaningPerson cleaner = new CleaningPerson(sharedResource);
			cleaners[i] = new Thread(cleaner, "cleaner" + i);
			cleaners[i].start();
		}
	}
}
