import static java.lang.Thread.sleep;

public class CookieBaker implements Runnable {

	private CookieJar jar;

	public CookieBaker(CookieJar jar) {
		this.jar = jar;
	}

	private void spendSomeTime(String what){
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (true){
			jar.startBaking();
			spendSomeTime("Baking");
			jar.finishBaking();
		}
	}
}
