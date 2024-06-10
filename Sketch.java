import processing.core.PApplet;

public class Sketch extends PApplet {
  // Constants
  int intNotes = 1;

  // Position and size arrays
  float[] fltSquare1 = new float[intNotes]; 
  int[] intSize1 = new int[intNotes];

  float[] fltSquare2 = new float[intNotes]; 
  int[] intSize2 = new int[intNotes];

  float[] fltSquare3 = new float[intNotes]; 
  int[] intSize3 = new int[intNotes];

  float[] fltSquare4 = new float[intNotes]; 
  int[] intSize4 = new int[intNotes];
  
  
  float fltSquareSpeed = 1;

  // State arrays
  boolean[] blnCanPressed1 = new boolean[intNotes];
  boolean[] blnHasPressed1 = new boolean[intNotes];
  boolean[] blnHold1 = new boolean[intNotes];

  boolean[] blnCanPressed2 = new boolean[intNotes];
  boolean[] blnHasPressed2 = new boolean[intNotes];
  boolean[] blnHold2 = new boolean[intNotes];

  boolean[] blnCanPressed3 = new boolean[intNotes];
  boolean[] blnHasPressed3 = new boolean[intNotes];
  boolean[] blnHold3 = new boolean[intNotes];

  boolean[] blnCanPressed4 = new boolean[intNotes];
  boolean[] blnHasPressed4 = new boolean[intNotes];
  boolean[] blnHold4 = new boolean[intNotes];




  // Game state variables
  int closestBlockIndex1 = -1; // Variable to store the closest block index
  boolean keyIsPressed1 = false; // Track key state

  int closestBlockIndex2 = -1; 
  boolean keyIsPressed2 = false;

  int closestBlockIndex3 = -1;
  boolean keyIsPressed3 = false; 

  int closestBlockIndex4 = -1; 
  boolean keyIsPressed4 = false;

  int intScore = 0; // Keep score
  
  
  public void settings() {
    size(800, 1000);
  }

  public void setup() {
    background(0);
    fltSquare1[0] = 0;
    fltSquare2[0] = 100;
    fltSquare3[0] = 200;
    fltSquare4[0] = 300;


    // Initialize booleans and sizes
    for (int i = 0; i < fltSquare1.length; i++) {
      blnCanPressed1[i] = false;
      blnHasPressed1[i] = false;
      blnHold1[i] = false;
      intSize1[i] = 250;

      blnCanPressed2[i] = false;
      blnHasPressed2[i] = false;
      blnHold2[i] = false;
      intSize2[i] = 250;

      blnCanPressed3[i] = false;
      blnHasPressed3[i] = false;
      blnHold3[i] = false;
      intSize3[i] = 250;

      blnCanPressed4[i] = false;
      blnHasPressed4[i] = false;
      blnHold4[i] = false;
      intSize4[i] = 250;
    }
    // hold blocks
    
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
    
    // Moving squares 1
    for (int i = 0; i < fltSquare1.length; i++) {
      if (!blnHasPressed1[i]){
        fill(0, 0, 255);
        rect(200, fltSquare1[i], 100, intSize1[i]);
        fltSquare1[i] += fltSquareSpeed; 
      }
      // Update clickable zone
      if (fltSquare1[i] + intSize1[i] > 550 && fltSquare1[i] <= 800) {
        blnCanPressed1[i] = true;
      } else {
        blnCanPressed1[i] = false;
      }
    }
    closestBlockIndex1 = closestBlock1();

    // moving square 2 
    for (int i = 0; i < fltSquare2.length; i++) {
      if (!blnHasPressed2[i]){
        fill(0, 0, 255);
        rect(300, fltSquare2[i], 100, intSize2[i]);
        fltSquare2[i] += fltSquareSpeed;
      }
      // Update clickable zone
      if (fltSquare2[i] + intSize2[i] > 550 && fltSquare2[i] <= 800) {
        blnCanPressed2[i] = true;
      } else {
        blnCanPressed2[i] = false;
      }
    }
    closestBlockIndex2 = closestBlock2();

    // moving square 3
    for (int i = 0; i < fltSquare3.length; i++) {
      if (!blnHasPressed3[i]){
        fill(0, 0, 255);
        rect(400, fltSquare3[i], 100, intSize3[i]);
        fltSquare3[i] += fltSquareSpeed;
      }
      // Update clickable zone
      if (fltSquare3[i] + intSize3[i] > 550 && fltSquare3[i] <= 800) {
        blnCanPressed3[i] = true;
      } else {
        blnCanPressed3[i] = false;
      }
    }
    closestBlockIndex3 = closestBlock3();

    // moving square 4
    for (int i = 0; i < fltSquare4.length; i++) {
      if (!blnHasPressed4[i]){
        fill(0, 0, 255);
        rect(500, fltSquare4[i], 100, intSize4[i]);
        fltSquare4[i] += fltSquareSpeed;
      }
      // Update clickable zone
      if (fltSquare4[i] + intSize4[i] > 550 && fltSquare4[i] <= 800) {
        blnCanPressed4[i] = true;
      } else {
        blnCanPressed4[i] = false;
      }
    }
    // Update the closest block index
    closestBlockIndex4 = closestBlock4();
  
    // Display the score in the top right corner
    fill(255);
    textSize(20);
    textAlign(RIGHT, TOP);
    text("Score: " + intScore, width - 10, 10);
  }

  // Method to handle key press
  public void keyPressed() {
    if (key == '1' && !keyIsPressed1) {
      keyIsPressed1 = true; 
      if (closestBlockIndex1 != -1 && blnCanPressed1[closestBlockIndex1] && !blnHasPressed1[closestBlockIndex1]) {
        // Check the block's position
        if ((fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1]) > 550 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 650) {
          blnHasPressed1[closestBlockIndex1] = true;
          // No points awarded for this zone
        } else if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 650 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 700) {
          blnHasPressed1[closestBlockIndex1] = true;
          intScore += 5;
        } else if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 700 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 750) {
          if (intSize1[closestBlockIndex1] < 26){
            blnHasPressed1[closestBlockIndex1] = true;
            }
          if (intSize1[closestBlockIndex1] > 26){
            blnHold1[closestBlockIndex1] = true;
          }
          intScore += 10;
        } else if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 750 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 800) {
           blnHasPressed1[closestBlockIndex1] = true;
          intScore += 5;
        }
      }
    }

    if (key == '2' && !keyIsPressed2) {
      keyIsPressed2 = true; 
      if (closestBlockIndex2 != -1 && blnCanPressed2[closestBlockIndex2] && !blnHasPressed2[closestBlockIndex2]) {
        // Check the block's position
        if ((fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2]) > 550 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 650) {
          blnHasPressed2[closestBlockIndex2] = true;
          // No points awarded for this zone
        } else if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 650 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 700) {
          blnHasPressed2[closestBlockIndex2] = true;
          intScore += 5;
        } else if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 700 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 750) {
          if (intSize2[closestBlockIndex2] < 26){
            blnHasPressed2[closestBlockIndex2] = true;
            }
          if (intSize2[closestBlockIndex2] > 26){
            blnHold2[closestBlockIndex2] = true;
          }
          intScore += 10;
        } else if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 750 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 800) {
           blnHasPressed2[closestBlockIndex2] = true;
          intScore += 5;
        }
      }
    }

    if (key == '3' && !keyIsPressed3) {
      keyIsPressed3 = true; 
      if (closestBlockIndex3 != -1 && blnCanPressed3[closestBlockIndex3] && !blnHasPressed3[closestBlockIndex3]) {
        // Check the block's position
        if ((fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3]) > 550 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 650) {
          blnHasPressed3[closestBlockIndex3] = true;
          // No points awarded for this zone
        } else if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 650 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 700) {
          blnHasPressed3[closestBlockIndex3] = true;
          intScore += 5;
        } else if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 700 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 750) {
          if (intSize3[closestBlockIndex3] < 26){
            blnHasPressed3[closestBlockIndex3] = true;
            }
          if (intSize3[closestBlockIndex3] > 26){
            blnHold3[closestBlockIndex3] = true;
          }
          intScore += 10;
        } else if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 750 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 800) {
           blnHasPressed3[closestBlockIndex3] = true;
          intScore += 5;
        }
      }
    }

    if (key == '4' && !keyIsPressed4) {
      keyIsPressed4 = true; 
      if (closestBlockIndex4 != -1 && blnCanPressed4[closestBlockIndex4] && !blnHasPressed4[closestBlockIndex4]) {
        // Check the block's position
        if ((fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4]) > 550 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 650) {
          blnHasPressed4[closestBlockIndex4] = true;
          // No points awarded for this zone
        } else if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 650 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 700) {
          blnHasPressed4[closestBlockIndex4] = true;
          intScore += 5;
        } else if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 700 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 750) {
          if (intSize4[closestBlockIndex4] < 26){
            blnHasPressed4[closestBlockIndex4] = true;
            }
          if (intSize4[closestBlockIndex4] > 26){
            blnHold4[closestBlockIndex4] = true;
          }
          intScore += 10;
        } else if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 750 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 800) {
           blnHasPressed4[closestBlockIndex4] = true;
          intScore += 5;
        }
      }
    }
  }

  public void keyReleased() {
    if (key == '1') {
      keyIsPressed1 = false;
      if (closestBlockIndex1 != -1 && blnCanPressed1[closestBlockIndex1] && blnHold1[closestBlockIndex1]) {
        // Ensure the release happens in the green zone
        if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 700 && fltSquare1[closestBlockIndex1] < 750) {
          // Calculate the percentage of the block that has passed the target zone
          float blockPassed = fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] - 700;
          float blockLength = intSize1[closestBlockIndex1];
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
        blnHold1[closestBlockIndex1] = false;
        blnHasPressed1[closestBlockIndex1] = true;
      }
    }

    if (key == '2') {
      keyIsPressed2 = false;
      if (closestBlockIndex2 != -1 && blnCanPressed2[closestBlockIndex2] && blnHold2[closestBlockIndex2]) {
        // Ensure the release happens in the green zone
        if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 700 && fltSquare2[closestBlockIndex2] < 750) {
          // Calculate the percentage of the block that has passed the target zone
          float blockPassed = fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] - 700;
          float blockLength = intSize2[closestBlockIndex2];
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
        blnHold2[closestBlockIndex2] = false;
        blnHasPressed2[closestBlockIndex2] = true;
      }
    }

    if (key == '3') {
      keyIsPressed3 = false;
      if (closestBlockIndex3 != -1 && blnCanPressed3[closestBlockIndex3] && blnHold3[closestBlockIndex3]) {
        // Ensure the release happens in the green zone
        if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 700 && fltSquare3[closestBlockIndex3] < 750) {
          // Calculate the percentage of the block that has passed the target zone
          float blockPassed = fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] - 700;
          float blockLength = intSize3[closestBlockIndex3];
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
        blnHold3[closestBlockIndex3] = false;
        blnHasPressed3[closestBlockIndex3] = true;
      }
    }

    if (key == '4') {
      keyIsPressed4 = false;
      if (closestBlockIndex4 != -1 && blnCanPressed4[closestBlockIndex4] && blnHold4[closestBlockIndex4]) {
        // Ensure the release happens in the green zone
        if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 700 && fltSquare4[closestBlockIndex4] < 750) {
          // Calculate the percentage of the block that has passed the target zone
          float blockPassed = fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] - 700;
          float blockLength = intSize4[closestBlockIndex4];
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
        blnHold4[closestBlockIndex4] = false;
        blnHasPressed4[closestBlockIndex4] = true;
      }
    }
  }
  
  // Method to return the closest block index
  public int closestBlock1() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare1.length; i++) { 
      if (blnCanPressed1[i] && !blnHasPressed1[i] && fltSquare1[i] + intSize1[i] > highestYValue) {
        highestYValue = fltSquare1[i];
        closestIndex = i;
      }
    }
    return closestIndex;
  }

  public int closestBlock2() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare2.length; i++) { 
      if (blnCanPressed2[i] && !blnHasPressed2[i] && fltSquare2[i] + intSize2[i] > highestYValue) {
        highestYValue = fltSquare2[i];
        closestIndex = i;
      }
    }
    return closestIndex;
  }

  public int closestBlock3() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare3.length; i++) { 
      if (blnCanPressed3[i] && !blnHasPressed3[i] && fltSquare3[i] + intSize3[i] > highestYValue) {
        highestYValue = fltSquare3[i];
        closestIndex = i;
      }
    }
    return closestIndex;
  }

  public int closestBlock4() {
    int closestIndex = -1;
    float highestYValue = -Float.MAX_VALUE;

    for (int i = 0; i < fltSquare4.length; i++) { 
      if (blnCanPressed4[i] && !blnHasPressed4[i] && fltSquare4[i] + intSize4[i] > highestYValue) {
        highestYValue = fltSquare4[i];
        closestIndex = i;
      }
    }
    return closestIndex;
  }
}
