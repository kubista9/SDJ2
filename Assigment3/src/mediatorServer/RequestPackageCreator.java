package mediatorServer;

public class RequestPackageCreator extends PackageCreator {
	protected NetworkPackage createPackage(String type, Object value){
		if (String.class.equals(value.getClass())){
			return createPackage(type, value);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
