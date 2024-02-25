public class Main {
	public static void main(String[] args) {
		ZooVisitor visitor = new ZooVisitor();
		VisitSeaBear seaBear = visitor.getSeaBear();

		seaBear.feed("Zookeeper");
		seaBear.pet("Child");
		seaBear.view("Personality person");

	}
}
