public interface ListADT<T> {
	public void add(int index, T element);

	public void set(int index, T element);

	public T remove(int index);

	public int indexOf(T element);
}
