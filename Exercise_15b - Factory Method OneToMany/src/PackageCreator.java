import java.util.ArrayList;
import java.util.List;

public abstract class PackageCreator {
	public abstract NetworkPackage createPackage(String type, Object value);

	protected List<NetworkPackage> getPackages(String type, List<Object> values) {
		List<NetworkPackage> packages = new ArrayList<>();
		for (Object value : values) {
			NetworkPackage pack = createPackage(type, value);
			packages.add(pack);
		}
		return packages;
	}
}

