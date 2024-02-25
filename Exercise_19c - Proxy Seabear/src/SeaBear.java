public class SeaBear implements VisitSeaBear{

	@Override
	public synchronized void view(String personType) {
		System.out.println("Bear is being viewed by a person");
	}

	@Override
	public synchronized void feed(String personType) {
		if (personType.equals("Zookeeper")){
			System.out.println("Bear is being fed by a zookeeper");
		}
	}

	@Override
	public synchronized void pet(String personType) {
		if (personType.equals("Child")){
			System.out.println("Bear is being pet by a child");
		}
	}
}
