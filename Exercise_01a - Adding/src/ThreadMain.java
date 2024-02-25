import java.util.ArrayList;

public class ThreadMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

		Adding a = new Adding("A",1000, list);
		Adding b = new Adding("B",1000, list);
		Adding c = new Adding("C",1000, list);

		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		//print statements?
	}
}
