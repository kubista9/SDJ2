public class ReadProxy implements ReadList{

	private HeavyWeightList list;
	private ListAccess listAccess;

	public ReadProxy(HeavyWeightList list, ListAccess listAccess) {
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
}
