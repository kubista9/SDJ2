public class WriteProxy implements ReadWriteList{
	private HeavyWeightList list;
	private ListAccess listAccess;

	public WriteProxy(HeavyWeightList list, ListAccess listAccess) {
		this.list = list;
		this.listAccess = listAccess;
	}

	public void terminate(){
		this.list.equals(null);
	}

	@Override
	public int read() {
		if (list.equals(null)) {
			throw new IllegalStateException();
		}
		else
			return list.read();
	}

	@Override
	public void write(int value) {
		if (!list.equals(null)) {
			list.write(value);
		}
	}
}
