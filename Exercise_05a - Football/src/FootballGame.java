import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FootballGame implements UnnamedPropertyChangeSubject {
	private String homeTeam;
	private String awayTeam;
	private int homeTeamGoal;
	private int awayTeamGoal;
	private FootballGame game;
	private PropertyChangeSupport property;

	public FootballGame(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamGoal = 0;
		this.awayTeamGoal = 0;
		property = new PropertyChangeSupport(this);
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void scoreGoal(String team){
		if (team.equals(homeTeam)){
			homeTeamGoal++;
		}
		else if (team.equals(awayTeam)){
			awayTeamGoal++;
		}
		property.firePropertyChange("Goal! ", team, getScore());
	}

	public String getScore(){
		return homeTeamGoal + " -" + awayTeamGoal;
	}

	public String endGame(){
		return getScore();
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		property.addPropertyChangeListener(listener);
	}

	@Override
	public void removeListener(PropertyChangeListener listener) {
		property.removePropertyChangeListener(listener);
	}
}
