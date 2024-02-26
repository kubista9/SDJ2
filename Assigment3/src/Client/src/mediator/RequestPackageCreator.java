package Client.src.mediator;

public class RequestPackageCreator extends PackageCreator
{
  @Override protected NetworkPackage createPackage(String type, Object value) {
    if(value.getClass().equals(String.class)){
      RequestPackage r = new RequestPackage(type,value.toString());
      return r;
    }
    else throw new IllegalArgumentException("Wrong passed information for RequestPackage!");
  }
}
