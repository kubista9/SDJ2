public class Person implements Runnable {

	private Toilet toiletBuilding;
	private String name;

	public Person(String name, Toilet toiletBuilding) {
		this.name = name;
		this.toiletBuilding = toiletBuilding;
	}

	public void run(){
//		String[] persons = {"Jakub","Maot","Samo","Mama","Oco"};
//		for (int i = 0; i < persons.length; i++){
//			int personNumber = (int) (Math.random() * persons.length);
//		}
//		Thread t1 = new Thread();
//
//		t1.start();
		toiletBuilding.stepIntoCabin();
		toiletBuilding.leaveCabin();
	}
}
