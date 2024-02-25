public class Main {
	public static void main(String[] args) {
		CookieJar jar = new CookieJar(30, 5, 16);
		CookieBaker baker = new CookieBaker(jar);
		CookieEater eater = new CookieEater(jar);

		Thread t1 = new Thread(baker);
		t1.start();

		Thread t2 = new Thread(eater);
		t2.start();
	}
}
