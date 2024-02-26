package mediatorServer;

public class MessagePackageCreator extends PackageCreator{
	protected NetworkPackage createPackage(String type, Object value){
		if (Message.class.equals(value.getClass())){
			return createPackage(type, value);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
