public class VibrationState implements AlertState{
	@Override
	public void click(Phone phone) {
		phone.setState(new SilentState());
	}

	@Override
	public String alert() {
		return "BRZZ BRZZ";
	}

	@Override
	public void volumeUp(Phone phone) {
		volumeUp(phone);
	}

	@Override
	public void volumeDown(Phone phone) {
		volumeDown(phone);
	}
}
