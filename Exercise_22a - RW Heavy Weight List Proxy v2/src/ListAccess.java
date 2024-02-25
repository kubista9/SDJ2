import java.util.ArrayList;

public class ListAccess implements ReadWriteAccess{
	private int readers;
	private int writers;
	private int waitingWriters;
	private ReadProxy readProxy;
	private WriteProxy writeProxy;
	private ArrayList<Thread> allowedReadAccess;
	private ArrayList<Thread> allowedWriteAccess;

	public ListAccess(HeavyWeightList heavyWeightList) {
		this.readers = 0;
		this.writers = 0;
		this.waitingWriters = 0;
		this.readProxy = new ReadProxy(heavyWeightList, this);
		this.writeProxy = new WriteProxy(heavyWeightList, this);
		this.allowedReadAccess = new ArrayList<>();
		this.allowedWriteAccess = new ArrayList<>();
	}

	@Override
	public synchronized ReadList acquireRead() {
		if (!allowedReadAccess.contains(Thread.currentThread())){
			allowedReadAccess.add(Thread.currentThread());
		}
		while (writers > 0 || waitingWriters> 0){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Acquire read");
		readers++;
		return readProxy;
	}

	@Override
	public synchronized void releaseRead() {
		if (allowedReadAccess.contains(Thread.currentThread())){
			allowedReadAccess.remove(Thread.currentThread());
		}
		readers--;
		if (readers == 0){
			notify();
		}
		System.out.println("Release read");
	}

	@Override
	public synchronized ReadWriteList acquireWrite() {
		if (!allowedWriteAccess.contains(Thread.currentThread())){
			allowedWriteAccess.add(Thread.currentThread());
		}
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
		return writeProxy;
	}

	@Override
	public synchronized void releaseWrite() {
		if (allowedWriteAccess.contains(Thread.currentThread())){
			allowedWriteAccess.remove(Thread.currentThread());
		}
		writers--;
		notifyAll();
		System.out.println("Release write");
	}

	public boolean hasReadAccess(Thread t){
		return(allowedReadAccess.contains(t));
	}

	public boolean hasWriteAccess(Thread t){
		return(allowedWriteAccess.contains(t));
	}
}
