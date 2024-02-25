import static java.lang.Thread.sleep;

public class CookieEater implements Runnable {

	private CookieJar jar;

	public CookieEater(CookieJar jar) {
		this.jar = jar;
	}

	private void spendSomeTime(String what){
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (true){
			spendSomeTime("waiting");
			spendSomeTime("waiting");
			spendSomeTime("waiting");
			jar.eat();
			spendSomeTime("Eating");
		}
	}
}
