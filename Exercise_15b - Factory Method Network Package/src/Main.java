public class Main {
	public static void main(String[] args) {
		TextPackage textpackage = new TextPackage("Type of this is this","whatever" );
		TaskPackage taskPackage = new TaskPackage("laogkwoajgiawngonawe", new Task("taskText",876));


		PackageCreator packageCreator = new TextPackageCreator();
//		packageCreator.createPackage(taskPackage.getType(), taskPackage);
		PackageCreator packageCreator2 = new TaskPackageCreator();
//		packageCreator2.createPackage(textpackage.getType(), textpackage);

		System.out.println(packageCreator.getPackage(textpackage.getType(), textpackage));
		System.out.println(packageCreator2.getPackage(taskPackage.getType(), taskPackage));
	}
}
