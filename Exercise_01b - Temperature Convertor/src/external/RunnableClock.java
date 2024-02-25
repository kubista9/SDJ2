package external;

import view.TemperatureViewController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable
{
  private DateTimeFormatter timeFormatter;
  private TemperatureViewController temperatureViewController;

  public RunnableClock(TemperatureViewController temperatureViewController)
  {
    this.timeFormatter = null;
    this.temperatureViewController = temperatureViewController;
  }

  public void run()
  {

    while (true) {
      LocalTime time = LocalTime.now();

      DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      String timeString = time.format(timeFormatter);

      System.out.println(timeString);
      temperatureViewController.showTime(timeString);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }

}
