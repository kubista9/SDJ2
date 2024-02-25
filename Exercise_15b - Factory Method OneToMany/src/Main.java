//public class Main {
//	public static void main(String[] args) {
//		PackageCreator taskPackageCreator = new TaskPackageCreator();
//		List<Object> taskValues = new ArrayList<>();
//		taskValues.add(new Task("Task 1", 10L));
//		taskValues.add(new Task("Task 2", 20L));
//		List<NetworkPackage> taskPackages = taskPackageCreator.getPackages("Task", taskValues);
//
//		PackageCreator textPackageCreator = new TextPackageCreator();
//		List<Object> textValues = new ArrayList<>();
//		textValues.add("Hello");
//		textValues.add("World");
//		List<NetworkPackage> textPackages = textPackageCreator.getPackages("Text", textValues);
//
//		// Access and use the created packages as needed
//		for (NetworkPackage pack : taskPackages) {
//			System.out.println(pack.toString());
//		}
//
//		for (NetworkPackage pack : textPackages) {
//			System.out.println(pack.toString());
//		}
//	}
//}
