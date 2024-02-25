import java.util.ArrayList;

public class CookieJar {
	private int cookieCountWhenToBake;
	private int numberOfCookiesInTheOven;
	private int cookiePlateSize;
	private ArrayList<Cookie> cookies;

	public CookieJar(int jarSize, int cookieCountWhenToBake, int cookiePlateSize) {
		this.cookieCountWhenToBake = cookieCountWhenToBake;
		this.numberOfCookiesInTheOven = cookiePlateSize;
		this.cookies = new ArrayList<>();
	}

	public synchronized void startBaking(){
		while (cookies.size() > cookieCountWhenToBake) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			numberOfCookiesInTheOven += cookiePlateSize;
			notifyAll();
		}
	}

	public synchronized int finishBaking(){
			for (int i = 0; i < cookiePlateSize; i++){
				cookies.add(new Cookie("Chocolate chip"));
			}
			notifyAll();
			return cookiePlateSize;
		}

	public synchronized void eat(){
		while (cookies.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cookies.remove(cookies.size()-1);
			notifyAll();
		}
	}
}
