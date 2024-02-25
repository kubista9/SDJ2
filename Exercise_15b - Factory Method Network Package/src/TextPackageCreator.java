public class TextPackageCreator extends PackageCreator{
	protected NetworkPackage createPackage(String type, Object value){
		if (Task.class.equals(value.getClass())){
			return createPackage(type, value);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
