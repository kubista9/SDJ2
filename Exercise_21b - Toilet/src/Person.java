public class Person implements Runnable{

	private PublicToilet toilet;

	public Person(PublicToilet toilet) {
		this.toilet = toilet;
	}

	@Override
	public void run() {
		while (true){
			toilet.stepIntoCabin(2);
			toilet.spendSomeTime(2000);
			toilet.leaveCabin();
		}
	}
}
