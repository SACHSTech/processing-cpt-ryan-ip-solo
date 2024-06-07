import processing.core.PApplet;

public class Sketch extends PApplet {
  // Variables
  int intNotes = 4;
  float[] fltSquare1 = new float[intNotes]; 
  int[] intSize1 = new int[intNotes];
  float fltSquareSpeed = 1;
  boolean[] blnCanPressed = new boolean[intNotes];
  boolean[] blnHasPressed = new boolean[intNotes];
  boolean[] blnHold = new boolean[intNotes];
  int closestBlockIndex = -1; // Variable to store the closest block index
  int intScore = 0; // keep score
  boolean keyIsPressed = false; // Track key state
  
  public void settings() {
    size(800, 1000);
  }

  public void setup() {
    background(0);
    fltSquare1[0] = 10000;
    fltSquare1[1] = 20000;
    fltSquare1[2] = 30000;
    fltSquare1[3] = 100; 

    // Initialize booleans
    for (int i = 0; i < fltSquare1.length; i++) {
      blnCanPressed[i] = false;
      blnHasPressed[i] = false;
      blnHold[i] = false;
      intSize1[i] = 25;
    }

    intSize1[3] = 300;
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
      rect(0, fltSquare1[i], width, intSize1[i]);
      fltSquare1[i] += fltSquareSpeed; 
      
      // Update clickable zone
      if (fltSquare1[i] + intSize1[i] > 550 && fltSquare1[i] <= 800) {
        blnCanPressed[i] = true;
      } else {
        blnCanPressed[i] = false;
      }
    }
    
    // Update the closest block index
    closestBlockIndex = closestBlock();
    
    // Display the score in the top right corner
    fill(255);
    textSize(20);
    textAlign(RIGHT, TOP);
    text("Score: " + intScore, width - 10, 10);
  }

  // Method to handle key press
  public void keyPressed() {
    if ((key == 'q' || key == 'Q') && !keyIsPressed) {
      keyIsPressed = true;
      println("key pressed works closest block index: " + closestBlockIndex);
      if (closestBlockIndex != -1 && blnCanPressed[closestBlockIndex] && !blnHasPressed[closestBlockIndex]) {
        // Check the block's position
        if ((fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex]) > 550 && fltSquare1[closestBlockIndex]  + intSize1[closestBlockIndex] < 650) {
          if (intSize1[closestBlockIndex] < 26){
            blnHasPressed[closestBlockIndex] = true;
          }
          println("no detection closest block index: " + closestBlockIndex + " y value" + fltSquare1[closestBlockIndex] + " " + + intSize1[closestBlockIndex]);
          // No points awarded for this zone
        } else if (fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex] > 650 && fltSquare1[closestBlockIndex]  + intSize1[closestBlockIndex] < 700) {
          if (intSize1[closestBlockIndex] < 26){
            blnHasPressed[closestBlockIndex] = true;
          }
          println("red closest block index: " + closestBlockIndex + " y value" + (fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex]) );
          intScore += 5;
        } else if (fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex] > 700 && fltSquare1[closestBlockIndex]  + intSize1[closestBlockIndex] < 750) {
          if (intSize1[closestBlockIndex] < 26){
            blnHasPressed[closestBlockIndex] = true;
          } else if (intSize1[closestBlockIndex] > 26){
            blnHold[closestBlockIndex] = true;
            println("key pressed works");
          }
          intScore += 10;
        } else if (fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex] > 750 && fltSquare1[closestBlockIndex]  + intSize1[closestBlockIndex] < 800) {
          if (intSize1[closestBlockIndex] < 26){
            blnHasPressed[closestBlockIndex] = true;
          }
          intScore += 5;
        }
      }
    }
  }

  public void keyReleased() {
  if (key == 'q' || key == 'Q') {
    keyIsPressed = false;
    println("key released closest block index: " + closestBlockIndex);
    if (closestBlockIndex != -1 && blnCanPressed[closestBlockIndex] && !blnHasPressed[closestBlockIndex] && blnHold[closestBlockIndex]) {
      // Ensure the release happens in the green zone
      println("release in green zone " + closestBlockIndex);
      if (fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex] > 700 && fltSquare1[closestBlockIndex] < 750) {
        // Calculate the percentage of the block that has passed the target zone
        float blockPassed = fltSquare1[closestBlockIndex] + intSize1[closestBlockIndex] - 700;
        float blockLength = intSize1[closestBlockIndex];
        float percentagePassed = blockPassed / blockLength;

        // Award points specifically for 95% or more hold
        if (percentagePassed >= 0.95) {
          intScore += 50; // Points awarded for holding 95% or more of block length
        } else {
          // Award points based on other hold percentages
          if (percentagePassed >= 0.75) {
            intScore += 30; // Highest points for holding more than 75% of block length
          } else if (percentagePassed >= 0.5) {
            intScore += 20; // 50-75% hold
          } else if (percentagePassed >= 0.25) {
            intScore += 10; // 25-50% hold
          } else if (percentagePassed >= 0.10) {
            intScore += 5; // 10-25% hold
          }
        }
      }
      blnHasPressed[closestBlockIndex] = true;
      blnHold[closestBlockIndex] = false;
    }
  }
}


  
  // Method to return the closest block index
  public int closestBlock() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare1.length; i++) { 
      if (blnCanPressed[i] && !blnHasPressed[i] && fltSquare1[i] + intSize1[i] > highestYValue) {
        highestYValue = fltSquare1[i];
        closestIndex = i;
      }
    }
    return closestIndex;
  }
}
