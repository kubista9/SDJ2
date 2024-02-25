public class BurgerBarCustomer implements Runnable {
	private int burgersToEat;
	private String name;
	private BurgerBar burgerbar;

	public BurgerBarCustomer(int burgersToEat, String name, BurgerBar burgerBar) {
		this.burgersToEat = burgersToEat;
		this.name = name;
		this.burgerbar = burgerBar;
	}

	@Override public void run(){
		for (int i = 0; i <= burgersToEat; i++){
			burgerbar.eatABurger(name);
			try {
				Thread.sleep(10000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
