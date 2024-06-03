import processing.core.PApplet;

public class Sketch1 extends PApplet {
  // variables
  float[] fltSquare1 = new float[3];
  float fltSquareSpeed = 5;

  public void settings() {
    size(800, 1000);
  }

  public void setup() {
    background(0);
    fltSquare1[0] = 100;
    fltSquare1[1] = 300;
    fltSquare1[2] = 500;
    fltSquare1[3] = 700;
  }

  public void draw() {
    background(0);
    fill(0, 255, 0);
    rect(0, 600, width, 100);
    for (int i = 0; i < fltSquare1.length; i++) {
      rect(0, fltSquare1[i], width, 100);
      fltSquare1[i] += fltSquareSpeed;
    }
  }
}
