public class SoundState implements AlertState{
	@Override
	public void click(Phone phone) {
		phone.setState(new VibrationState());
	}

	@Override
	public String alert() {
		return "DRIIIIIING";
	}

	@Override
	public void volumeUp(Phone phone) {
		if (phone.getVolume() < 10){
			phone.volumeUp();
		}
	}

	@Override
	public void volumeDown(Phone phone) {
		if (phone.getVolume() > 0){
			phone.volumeDown();
		}
	}
}
