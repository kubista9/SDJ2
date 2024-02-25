public class Reader implements Runnable{
	private ReadWriteAccess readWriteAccess;

	public Reader(ReadWriteAccess lock){
		this.readWriteAccess = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++){
			int waitTime = (int) ((Math.random() * (10) * 1000));
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Waiting");

			ReadList readList = readWriteAccess.acquireRead();
			int waitTime2 = (int) (5 + (Math.random() * (10 - 5)) * 1000);
			try {
				int x = readList.read();
				Thread.sleep(waitTime2);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			readWriteAccess.releaseRead();
			System.out.println("Read released");
		}
	}
}
