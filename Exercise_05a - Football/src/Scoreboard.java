import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Scoreboard implements PropertyChangeListener {
	private FootballGame game;

	public Scoreboard(FootballGame game) {
		this.game = game;
		showScore(game.getScore());
	}

	public void showScore(String score) {
		System.out.println("SCOREBOARD: " + score);
	}

	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("Event name: " + event.getPropertyName());
		System.out.println("First value: " + event.getOldValue());
		System.out.println("Second value: " + event.getNewValue());
	}
}
