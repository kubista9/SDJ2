public class Program implements Runnable{
	private String program;
	private long maxFrequency;
	private String action;
	private int count;
	public static long RUNTIME = 100;

	public Program (String program, String action, int count){
		this.program = program;
		this.maxFrequency = 0;
		this.action = action;
		this.count = count;
	}

	private void normalOperation(){
		System.out.println(program +"wants to" +action);
		try {
			Thread.sleep(RUNTIME);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		normalOperation();
	}
}
