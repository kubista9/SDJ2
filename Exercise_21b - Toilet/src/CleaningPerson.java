public class CleaningPerson implements Runnable {

	private PublicToilet toilet;

	public CleaningPerson(PublicToilet toilet) {
		this.toilet = toilet;
	}

	@Override
	public void run() {
		toilet.startCleaning();
		toilet.spendSomeTime(4500);
		toilet.endCleaning();
	}
}
