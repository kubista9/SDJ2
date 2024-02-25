public class WriteProxy implements ReadWriteList{
	private HeavyWeightList list;
	private ListAccess listAccess;

	public WriteProxy(HeavyWeightList list, ListAccess listAccess) {
		this.list = list;
		this.listAccess = listAccess;
	}

	@Override
	public int read() {
		if (listAccess.hasReadAccess(Thread.currentThread()) == false) {
			throw new IllegalStateException();
		}
		else
			return list.read();
	}

	@Override
	public void write(int value) {
		if (listAccess.hasWriteAccess(Thread.currentThread()) == false) {
			throw new IllegalStateException();
		}
		else list.write(value);
	}
}
