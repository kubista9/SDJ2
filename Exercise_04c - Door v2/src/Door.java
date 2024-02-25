public class Door{
	private DoorState state;

	public Door(){
		state = new DoorClosed(this);
	}

	public void click(){
		state.click(this);
		status();
	}

	public void setState(DoorState state){
		this.state = state;
		status();
	}

	public String status(){
		return state.status();
	}

}
