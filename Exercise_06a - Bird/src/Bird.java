import utility.observer.subject.LocalSubject;

import utility.observer.listener.GeneralListener;
import utility.observer.subject.LocalSubject;
import utility.observer.subject.PropertyChangeHandler;

public class Bird implements LocalSubject<String, String> {

	private PropertyChangeHandler<String, String> property;

	public Bird() {
		property = new PropertyChangeHandler<>(this);
	}

	public void flashTheWings(){
		property.firePropertyChange("Flaps wings", "", "Peacock flashes its wings" );
	}

	public void toWhistle(){
		property.firePropertyChange("Whistles","", "Peacock whistles" );
	}

	@Override
	public boolean addListener(GeneralListener<String, String> listener, String... propertyNames){
		return property.addListener(listener, propertyNames);
	}

	@Override
	public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames){
		return property.removeListener(listener, propertyNames);
	}
}
