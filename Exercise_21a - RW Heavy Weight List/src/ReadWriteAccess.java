public interface ReadWriteAccess {
	public ReadList acquireRead();
	public void releaseRead();
	public ReadWriteList acquireWrite();
	public void releaseWrite();
}
