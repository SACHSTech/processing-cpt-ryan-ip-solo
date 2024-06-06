import processing.core.PApplet;

public class Sketch2 extends PApplet {
  // variables
  int intNotes = 4;
  float[] fltSquare1 = new float[intNotes]; 
  float fltSquareSpeed = 8;
  boolean[] blnCanPressed = new boolean[intNotes];
  boolean[] blnHasPressed = new boolean[intNotes];
  int closestBlockIndex = -1; // Variable to store the closest block index
  int intScore = 0; // keep score
  
  public void settings() {
    size(800, 1000);
  }

  public void setup() {
    background(0);
    fltSquare1[0] = -1000;
    fltSquare1[1] = 0;
    fltSquare1[2] = -100;
    fltSquare1[3] = -3000; 

    // Initialize booleans
    for (int i = 0; i < fltSquare1.length; i++) {
      blnCanPressed[i] = false;
      blnHasPressed[i] = false;
    }
  }

  public void draw() {
    background(0);
    // Max points
    fill(0, 255, 0);
    rect(0, 700, width, 50);
    
    // Half points
    fill(255, 0, 0);
    rect(0, 750, width, 50);
    rect(0, 650, width, 50);

    // No points zone if tap too early
    fill(255);
    rect(0, 550, width, 100);
    
    // Moving squares
    for (int i = 0; i < fltSquare1.length; i++) {
      fill(0, 0, 255);
      rect(0, fltSquare1[i], width, 25);
      fltSquare1[i] += fltSquareSpeed; 
      
      // Update clickable zone
      if (fltSquare1[i] + 25 > 550 && fltSquare1[i] <= 800) {
        blnCanPressed[i] = true;
      } else {
        blnCanPressed[i] = false;
      }
    }
    
    // Update the closest block index
    closestBlockIndex = closestBlock();

    // Detect key press
    if (keyPressed) {
      if (key == 'q' || key == 'Q') {
        if (closestBlockIndex != -1 && blnCanPressed[closestBlockIndex] && !blnHasPressed[closestBlockIndex]) {
          // Check the block's position
          if (fltSquare1[closestBlockIndex] > 550 && fltSquare1[closestBlockIndex] < 650) {
            blnHasPressed[closestBlockIndex] = true;
            // No points awarded for this zone
          } else if (fltSquare1[closestBlockIndex] > 650 && fltSquare1[closestBlockIndex] < 700) {
            blnHasPressed[closestBlockIndex] = true;
            intScore += 5;
          } else if (fltSquare1[closestBlockIndex] > 700 && fltSquare1[closestBlockIndex] < 750) {
            blnHasPressed[closestBlockIndex] = true;
            intScore += 10;
          } else if (fltSquare1[closestBlockIndex] > 750 && fltSquare1[closestBlockIndex] < 800) {
            blnHasPressed[closestBlockIndex] = true;
            intScore += 5;
          }
        }
      }
      keyPressed = false; // Reset keyPressed
    }
    
    // Display the score in the top right corner
    fill(255);
    textSize(20);
    textAlign(RIGHT, TOP);
    text("Score: " + intScore, width - 10, 10);
  }

  // Method to return the closest block index
  public int closestBlock() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare1.length; i++) {
      if (blnCanPressed[i] && !blnHasPressed[i] && fltSquare1[i] > highestYValue) {
        highestYValue = fltSquare1[i];
        closestIndex = i;
      }
    }
    
    return closestIndex;
  }
}
