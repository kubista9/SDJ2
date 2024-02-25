public class Writer implements Runnable{
	private ReadWriteAccess readWriteAccess;

	public Writer(ReadWriteAccess lock){
		this.readWriteAccess = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++){
			int waitTime = (int) (5 + (Math.random() * (10 - 5)) * 1000);
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			ReadWriteList writeList = readWriteAccess.acquireWrite();
			int waitTime2 = (int) (5 + (Math.random() * (10 - 5)) * 1000);
			try {
				writeList.write(8);
				Thread.sleep(waitTime2);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			readWriteAccess.releaseWrite();
		}
	}
}
