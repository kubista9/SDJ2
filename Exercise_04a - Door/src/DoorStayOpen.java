public class DoorStayOpen extends DoorState{
	public void click(Door door){
		door.setState(new DoorStayOpen());
	}

	public void timeout(Door door){
		door.setState(new DoorClosing());
	}
}
