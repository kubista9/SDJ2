public class ZooVisitor {
	private VisitSeaBear seaBear;

	public ZooVisitor(){
		this.seaBear = new SeaBearGuard();
	}

	public VisitSeaBear getSeaBear(){
		return seaBear;
	}
}
