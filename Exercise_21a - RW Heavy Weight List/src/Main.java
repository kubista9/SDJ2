public class Main {
	public static void main(String[] args) {

		ReadWriteAccess sharedResource = new ListAccess(new HeavyWeightList(2, 4));
		Thread[] readers = new Thread[30];
		for (int i = 0; i < readers.length; i++) {
			Reader reader = new Reader(sharedResource);
			readers[i] = new Thread(reader, "Reader" + i);
			readers[i].start();
		}
		Thread[] writers = new Thread[5];
		for (int i = 0; i < writers.length; i++) {
			Writer writer = new Writer(sharedResource);
			writers[i] = new Thread(writer, "Writer" + i);
			writers[i].start();
		}

	}
}
