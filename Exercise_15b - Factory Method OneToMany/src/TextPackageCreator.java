public class TextPackageCreator extends PackageCreator {
	public NetworkPackage createPackage(String type, Object value) {
		if (String.class.equals(value.getClass())) {
			String text = (String) value;
			return new TextPackage(type, text);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
