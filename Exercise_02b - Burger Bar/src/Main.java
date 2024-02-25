public class Main {
	public static void main(String[] args) {
		BurgerBar burgerBar = new BurgerBar(10);

		Thread[] customerThreads = new Thread[5];
		for (int i=0; i<customerThreads.length; i++) {
			BurgerBarCustomer customer = new BurgerBarCustomer(1, "Customer" + (i+1), burgerBar);
			customerThreads[i] = new Thread(customer);
			customerThreads[i].start();
		}

		Thread[] employeeThreads = new Thread[2];
		for (int i=0; i<employeeThreads.length; i++) {
			BurgerBarEmployee employee = new BurgerBarEmployee(burgerBar, "Employee" + (i+1));
			employeeThreads[i] = new Thread(employee);
			employeeThreads[i].setDaemon(true);
			employeeThreads[i].start();
		}

		for (int i=0; i<customerThreads.length; i++) {
			try {
				customerThreads[i].join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Burger bar is closed");
	}
}
