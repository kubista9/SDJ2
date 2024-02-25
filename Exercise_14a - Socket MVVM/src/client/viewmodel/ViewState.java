package client.viewmodel;

public class ViewState
{
  private String number;
  private boolean remove;

  public ViewState()
  {
    remove=false;
    number=null;
  }
  //CASE REMOVE: remove==true && number!=null
  //CASE ADD: remove==false && number==null
  //CASE EDIT: remove==false && number!=null

  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public void removeNumber()
  {
    this.number=null;
  }

  public boolean isRemove()
  {
    return remove;
  }

  public void setRemove(boolean remove)
  {
    this.remove = remove;
  }

}
