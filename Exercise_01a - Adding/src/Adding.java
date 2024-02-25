import java.util.ArrayList;

public class Adding implements Runnable{
	private String id;
	private long sleepTime;
	private ArrayList<String> list;

	public Adding(String id, long sleepTime, ArrayList<String> list) {
		this.id = id;
		this.sleepTime = sleepTime;
		this.list = list;
	}

	public void run(){
		for (int i = 0; i <= 5; i++){
			list.add(id + i);
			try {
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e){
				throw new RuntimeException(e);
			}

			System.out.println(id);
			System.out.println(list.get(i));
			System.out.println(list);
		}
	}
}
