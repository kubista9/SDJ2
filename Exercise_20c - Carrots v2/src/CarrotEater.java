public class CarrotEater implements Runnable{
	private CarrotBunch carrots;
	public CarrotEater(CarrotBunch carrots) {
		this.carrots = carrots;
	}

	@Override
	public void run() {
		while (true){
			carrots.eat();
			System.out.println(carrots.getSize());
		}
	}
}
