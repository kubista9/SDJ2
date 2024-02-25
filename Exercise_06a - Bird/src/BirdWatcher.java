import utility.observer.event.ObserverEvent;
import utility.observer.listener.LocalListener;

public class BirdWatcher implements LocalListener<String, String> {

	private Bird bird;

	public BirdWatcher(Bird bird){
		bird.addListener(this);
	}

	@Override public void propertyChange(ObserverEvent<String, String> event){
		if (event.getPropertyName().equals("Flaps wings")){
			System.out.println("I am normal watcher");
		}
		if (event.getPropertyName().equals("Whistles")){
			System.out.println("How nice");
		}
	}
}
