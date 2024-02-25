public class Mailbox implements Runnable{
//	private long maxFrequency;
	private int count;
	public static final long RUNTIME = 100;

	public Mailbox (int count){
//		this.maxFrequency = 0;
		this.count = count;
	}

	private void waitingForMails(){
		try {
			Thread.sleep(RUNTIME/20);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run(){

		System.out.println("New mail in your mailbox...");
		waitingForMails();
	}
}
