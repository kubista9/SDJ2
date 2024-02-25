public class ReadProxy implements ReadList{

	private HeavyWeightList list;
	private ListAccess listAccess;

	public ReadProxy(HeavyWeightList list, ListAccess listAccess) {
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
}
