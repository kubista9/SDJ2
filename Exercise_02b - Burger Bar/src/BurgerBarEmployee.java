public class BurgerBarEmployee implements Runnable {
	private String name;
	private BurgerBar burgerBar;

	public BurgerBarEmployee(BurgerBar burgerBar, String name) {
		this.burgerBar = burgerBar;
		this.name = name;
	}

	public void run(){
		for (int i = 1; i > 0; i++){
			burgerBar.makeABurger(name);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
