public interface Buffer<Carrot> {
	public void put(Carrot carrot);
	public Carrot take();
	public Carrot look();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
}
