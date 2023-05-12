package Events;

import javafx.scene.control.Button;

public class ToggleButton extends Button{
  private boolean on;
  
  public ToggleButton(){
    this("");
  }

  public ToggleButton(String text){
    super(text);
    setOn(false);
  }

  public void setOn(boolean newValue){
    on = newValue;
    if (on) {
      setStyle("-fx-base: rgb(255,255,255);");
    }else {
      setStyle("-fx-base: rgb(0,0,0);");
    }
  }
  
  public void toggle(){
    setOn(!on);
  }
}