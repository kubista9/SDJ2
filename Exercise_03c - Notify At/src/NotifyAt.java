import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotifyAt {

	private LocalDateTime time;

	public NotifyAt(LocalDateTime time) {
		this.time = time;
	}

	public void run(){
		LocalDateTime localDateTime = LocalDateTime.now();
		while (localDateTime.isBefore(time)){
			try {
				Thread.sleep(Math.abs(time.getSecond()-localDateTime.getSecond()/10)*1000);
			}
			catch (InterruptedException e){
				throw  new RuntimeException();
			}
			localDateTime = localDateTime.now();
		}
		System.out.println("BRRRRRNK!! " + localDateTime + Math.abs(time.getSecond() - localDateTime.getSecond()) + "seconds after: " + time);
	}
}

