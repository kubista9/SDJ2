public class SilentState implements AlertState{
	@Override
	public void click(Phone phone) {
		phone.setState(new SoundState());
	}

	@Override
	public String alert() {
		return "Silent";
	}

	@Override
	public void volumeUp(Phone phone) {

	}

	@Override
	public void volumeDown(Phone phone) {
		//nothing
	}
}
