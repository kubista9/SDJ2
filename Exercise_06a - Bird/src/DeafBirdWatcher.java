import utility.observer.event.ObserverEvent;
import utility.observer.listener.LocalListener;

public class DeafBirdWatcher implements LocalListener<String, String> {

	private Bird bird;

	public DeafBirdWatcher(Bird bird){
		bird.addListener(this);
	}

	@Override public void propertyChange(ObserverEvent<String, String> event){
		if (event.getPropertyName().equals("Flaps wings")){
			System.out.println("I am deaf and it is awesome");
		}
	}
}
