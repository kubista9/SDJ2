package mediatorServer;

public abstract class PackageCreator {
	protected abstract NetworkPackage createPackage(String type, Object value);
	protected NetworkPackage getPackage(String type,Object value){
		return createPackage(type,value);
	}
}
