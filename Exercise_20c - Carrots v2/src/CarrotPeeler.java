import javax.swing.text.html.HTML;

public class CarrotPeeler implements Runnable {

	private CarrotBunch carrots;

	public CarrotPeeler(CarrotBunch carrots) {
		this.carrots = carrots;
	}

	@Override
	public void run() {
		while (true){
			carrots.peel(carrots);
		}
	}
}
