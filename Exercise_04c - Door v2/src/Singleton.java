public class Singleton {
	private static Singleton instance;
	private static Object lock = new Object();

	private Singleton() { // Private constructor to prevent instantiation
	}

	public static Singleton getInstance() {
		if (instance == null) { // Check if an instance already exists
			synchronized (lock) {// Synchronize access to the critical section
				if (instance == null) { // Double-check inside the critical section
					instance = new Singleton(); // Create a new instance if it doesn't exist
				}
			}
		}
		return instance; // Return the existing or newly created instance
	}
}
