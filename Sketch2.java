import processing.core.PApplet;

public class Sketch2 extends PApplet {
  // Constants
  int intNotes = 4;

   int y =  725;
   
    int intKeyPressed = 0;
    int intKeyReleased = 0;

  
  
  
  public void settings() {
    size(800, 1000);
  }

  public void setup() {
    background(0);
    
   


    
  }

  public void draw() {
    int y =- 6;

  }
  public void keyPressed() {
      if (key == 'q'){
        intKeyPressed = y;
      }
  }
  public void keyReleased(){
    if (key =='q'){
      intKeyReleased = y;
      println(intKeyPressed + ", " + intKeyReleased);
    }
    

  }
}