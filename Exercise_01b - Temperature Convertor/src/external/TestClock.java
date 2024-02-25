package external;

import view.TemperatureViewController;

public class TestClock
{
  public static void main(String[] args)
  {
    RunnableClock clock = new RunnableClock(new TemperatureViewController());
    Thread t1 = new Thread(clock);

    t1.start();
  }
}
