package Client.src.model;

import Client.src.utility.observer.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject
{
  public String logIn(String username) throws InterruptedException;

  public String post(String message) throws InterruptedException;

  public void exit() throws InterruptedException;
}
