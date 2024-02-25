public interface CdPersistence {
	CdListload();
	void save(CdList cdList);
	void save(Cd cd);
	void remove(Cd cd);
	void clear();
}
