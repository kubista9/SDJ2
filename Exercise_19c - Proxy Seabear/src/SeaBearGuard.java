public class SeaBearGuard implements VisitSeaBear{

	private SeaBear seaBear;

	public SeaBearGuard() {
		this.seaBear = new SeaBear();
	}

	@Override
	public synchronized void view(String personType) {
		seaBear.view(personType);
	}

	@Override
	public synchronized void feed(String personType) {
		if (personType.equals("Zookeeper")){
			seaBear.feed(personType);
		}
	}

	@Override
	public synchronized void pet(String personType) {
		if (personType.equals("Child")){
			seaBear.pet(personType);
		}
	}
}
