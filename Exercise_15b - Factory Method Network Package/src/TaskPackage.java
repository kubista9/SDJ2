public class TaskPackage extends NetworkPackage{
	private Task task;

	public TaskPackage(String type, Task task) {
		super(type);
		this.task = task;
	}

	public Task getTask() {
		return task;
	}

	public String toString(){
		return "Task: " + task;
	}
}
