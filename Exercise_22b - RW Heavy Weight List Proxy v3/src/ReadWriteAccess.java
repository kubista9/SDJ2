public interface ReadWriteAccess {
	public ReadList acquireRead();
	public void releaseRead(ReadList readList);
	public ReadWriteList acquireWrite();
	public void releaseWrite(ReadWriteList readWriteList);
}
