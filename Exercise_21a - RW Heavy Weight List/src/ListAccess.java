public class ListAccess implements ReadWriteAccess{
	private int readers;
	private int writers;
	private int waitingWriters;
	private HeavyWeightList list;

	public ListAccess(HeavyWeightList list) {
		this.readers = 0;
		this.writers = 0;
		this.waitingWriters = 0;
		this.list = list;
	}

	@Override
	public synchronized ReadList acquireRead() {
		while (writers > 0 || waitingWriters> 0){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Acquire read");
		readers++;
		return list;
	}

	@Override
	public synchronized void releaseRead() {
		readers--;
		if (readers == 0){
			notify();
		}
		System.out.println("Release read");
	}

	@Override
	public synchronized ReadWriteList acquireWrite() {
		waitingWriters++;
		while (readers > 0 || writers > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Acquire Write");
		waitingWriters--;
		writers++;
		return list;
	}

	@Override
	public synchronized void releaseWrite() {
		writers--;
		notifyAll();
		System.out.println("Release write");
	}
}
