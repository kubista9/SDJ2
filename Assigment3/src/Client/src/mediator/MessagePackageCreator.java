package Client.src.mediator;

public class MessagePackageCreator extends PackageCreator{
  @Override protected NetworkPackage createPackage(String type, Object value) {
    if(value.getClass().equals(Message.class)){
      MessagePackage m= new MessagePackage(type,(Message) value);
      return m;
    }
    else throw new IllegalArgumentException("Wrong passed information for MessagePackage!");
  }
}
