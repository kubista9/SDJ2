import utility.observer.event.ObserverEvent;
import utility.observer.listener.LocalListener;

public class BlindBirdWatcher implements LocalListener<String, String> {

	private Bird bird;

	public BlindBirdWatcher(Bird bird){
		bird.addListener(this);
	}

	@Override public void propertyChange(ObserverEvent<String, String> event){
		if (event.getPropertyName().equals("Whistles")){
			System.out.println("How nice");
		}
	}
}
