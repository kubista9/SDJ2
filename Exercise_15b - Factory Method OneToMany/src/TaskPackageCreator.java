public class TaskPackageCreator extends PackageCreator {
	public NetworkPackage createPackage(String type, Object value) {
		if (Task.class.equals(value.getClass())) {
			Task task = (Task) value;
			return new TaskPackage(type, task);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
