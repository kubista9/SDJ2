package server;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
public class TaskList implements UnnamedPropertyChangeSubject {
	private ArrayList<Task> taskList;
	private PropertyChangeSupport property;
	public TaskList(){
		taskList = new ArrayList<Task>();
		this.property = new PropertyChangeSupport(this);
	}

	public synchronized void add(Task task){
		taskList.add(task);
		property.firePropertyChange("ADD","",task.toString());
	}

	public synchronized Task getAndRemoveNextTask(){
		if (taskList.size() > 0){
			property.firePropertyChange("REMOVE","", taskList.get(0).toString());
			return taskList.remove(0);
		}
		return null;
	}

	public synchronized int size(){
		return taskList.size();
	}

	public synchronized String toString(){
		return "Tasks=" + taskList;
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		property.addPropertyChangeListener(listener);
	}

	@Override
	public void removeListener(PropertyChangeListener listener) {
		property.removePropertyChangeListener(listener);
	}
}
