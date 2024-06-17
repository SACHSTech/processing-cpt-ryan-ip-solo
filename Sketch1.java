import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  // Constants
  private Audio[] audios;
  PImage Title;
  PImage Menu;
  PImage tutorialCover;
  PImage tutorialLevel;
  PImage Virus_cover;
  PImage Virus_cover_black;
  PImage tutorialCover_black;
  PImage Virus_background;
  PImage Score;
  PImage PauseGameImage;

  // Images
  
  int intNotes1 = 38;
  int intNotes2 = 65;
  int intNotes3 = 70;
  int intNotes4 = 24;
  int intPage = 0;

  // Position and size arrays
  float[] fltSquare1 = new float[intNotes1];
  float[] fltSquare2 = new float[intNotes2];
  float[] fltSquare3 = new float[intNotes3];
  float[] fltSquare4 = new float[intNotes4];

  int[] intSize1 = new int[intNotes1];
  int[] intSize2 = new int[intNotes2];
  int[] intSize3 = new int[intNotes3];
  int[] intSize4 = new int[intNotes4];

  float fltSquareSpeed = 6;

  // State arrays
  boolean[] blnCanPressed1 = new boolean[intNotes1];
  boolean[] blnHasPressed1 = new boolean[intNotes1];
  boolean[] blnHold1 = new boolean[intNotes1];

  boolean[] blnCanPressed2 = new boolean[intNotes2];
  boolean[] blnHasPressed2 = new boolean[intNotes2];
  boolean[] blnHold2 = new boolean[intNotes2];

  boolean[] blnCanPressed3 = new boolean[intNotes3];
  boolean[] blnHasPressed3 = new boolean[intNotes3];
  boolean[] blnHold3 = new boolean[intNotes3];

  boolean[] blnCanPressed4 = new boolean[intNotes4];
  boolean[] blnHasPressed4 = new boolean[intNotes4];
  boolean[] blnHold4 = new boolean[intNotes4];

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

    Title = loadImage("Page1.png");
    Menu = loadImage("Page2.png");
    tutorialLevel = loadImage("Tutorial_gameplay.png");
    tutorialCover = loadImage("Tutorial.png");
    Virus_cover = loadImage("Virus_cover.jpg");
    Virus_background = loadImage("Virus_background.png");
    Score = loadImage("score.png");
    PauseGameImage = loadImage("Pause.png");

    tutorialCover.resize(250, 300);
    Virus_cover.resize(250, 300);

    // Initialize audio
    String[] audioPaths = { "Level1.wav" };  // Adjust based on your audio file location
    audios = Audio.initializeAudioArray(audioPaths);

    // Reset arrays for intNotes1
    for (int i = 0; i < intNotes1; i++) {
      blnCanPressed1[i] = false;
      blnHasPressed1[i] = false;
      blnHold1[i] = false;
      intSize1[i] = 25;
    }

    // Reset arrays for intNotes2
    for (int i = 0; i < intNotes2; i++) {
      blnCanPressed2[i] = false;
      blnHasPressed2[i] = false;
      blnHold2[i] = false;
      intSize2[i] = 25;
    }

    // Reset arrays for intNotes3
    for (int i = 0; i < intNotes3; i++) {
      blnCanPressed3[i] = false;
      blnHasPressed3[i] = false;
      blnHold3[i] = false;
      intSize3[i] = 25;
    }

    // Reset arrays for intNotes4
    for (int i = 0; i < intNotes4; i++) {
      blnCanPressed4[i] = false;
      blnHasPressed4[i] = false;
      blnHold4[i] = false;
      intSize4[i] = 25;
    }
    // Assigning numbers to fltSquare1
    fltSquare1[0] = -5485;   // Updated
    fltSquare1[1] = -6607;   // Updated
    fltSquare1[2] = -8875;   // Updated
    fltSquare1[3] = -9937;   // Updated
    fltSquare1[4] = -11023;  // Updated
    fltSquare1[5] = -13309;  // Updated
    fltSquare1[6] = -13447;  // Updated
    fltSquare1[7] = -14557;  // Updated
    fltSquare1[8] = -15115;  // Updated
    fltSquare1[9] = -15793;  // Updated
    fltSquare1[10] = -16345; // Updated
    fltSquare1[11] = -17041; // Updated
    fltSquare1[12] = -17599; // Updated
    fltSquare1[13] = -17671; // Updated
    fltSquare1[14] = -17737; // Updated
    fltSquare1[15] = -17875; // Updated
    fltSquare1[16] = -18433; // Updated
    fltSquare1[17] = -21193; // Updated
    fltSquare1[18] = -21337; // Updated
    fltSquare1[19] = -21475; // Updated
    fltSquare1[20] = -21619; // Updated
    fltSquare1[21] = -21763; // Updated
    fltSquare1[22] = -21889; // Updated
    fltSquare1[23] = -22033; // Updated
    fltSquare1[24] = -22159; // Updated
    fltSquare1[25] = -22309; // Updated
    fltSquare1[26] = -22441; // Updated
    fltSquare1[27] = -22579; // Updated
    fltSquare1[28] = -22711; // Updated
    fltSquare1[29] = -22849; // Updated
    fltSquare1[30] = -22993; // Updated
    fltSquare1[31] = -25627; // Updated
    fltSquare1[32] = -26521; // Updated
    fltSquare1[33] = -28831; // Updated
    fltSquare1[34] = -28939; // Updated
    fltSquare1[35] = -29863; // Updated
    fltSquare1[36] = -32281; // Updated
    fltSquare1[37] = -33355; // Updated
    

    // Assigning numbers to fltSquare2
    fltSquare2[0] = -1237;   // Updated
    fltSquare2[1] = -1489;   // Updated
    fltSquare2[2] = -2383;   // Updated
    fltSquare2[3] = -2587;   // Updated
    fltSquare2[4] = -3505;   // Updated
    fltSquare2[5] = -3691;   // Updated
    fltSquare2[6] = -4597;   // Updated
    fltSquare2[7] = -4789;   // Updated
    fltSquare2[8] = -5557;   // Updated
    fltSquare2[9] = -6679;   // Updated
    fltSquare2[10] = -8185;  // Updated
    fltSquare2[11] = -8737;  // Updated
    fltSquare2[12] = -9231;  // Updated
    fltSquare2[13] = -10003; // Updated
    fltSquare2[14] = -11113; // Updated
    fltSquare2[15] = -12613; // Updated
    fltSquare2[16] = -13165; // Updated
    fltSquare2[17] = 900; // Updated
    fltSquare2[18] = -14683; // Updated
    fltSquare2[19] = -15241; // Updated
    fltSquare2[20] = -15943; // Updated
    fltSquare2[21] = -16489; // Updated
    fltSquare2[22] = -16561; // Updated
    fltSquare2[23] = -16639; // Updated
    fltSquare2[24] = -17179; // Updated
    fltSquare2[25] = -18007; // Updated
    fltSquare2[26] = -18565; // Updated
    fltSquare2[27] = -18979; // Updated
    fltSquare2[28] = -19117; // Updated
    fltSquare2[29] = -19273; // Updated
    fltSquare2[30] = -19411; // Updated
    fltSquare2[31] = -19549; // Updated
    fltSquare2[32] = -19669; // Updated
    fltSquare2[33] = -19819; // Updated
    fltSquare2[34] = -19951; // Updated
    fltSquare2[35] = -20089; // Updated
    fltSquare2[36] = -20227; // Updated
    fltSquare2[37] = -20371; // Updated
    fltSquare2[38] = -20503; // Updated
    fltSquare2[39] = -20653; // Updated
    fltSquare2[40] = -20803; // Updated
    fltSquare2[41] = -20923; // Updated
    fltSquare2[42] = -21061; // Updated
    fltSquare2[43] = -23131; // Updated
    fltSquare2[44] = -23269; // Updated
    fltSquare2[45] = -23425; // Updated
    fltSquare2[46] = -23689; // Updated
    fltSquare2[47] = -23977; // Updated
    fltSquare2[48] = -24241; // Updated
    fltSquare2[49] = -24523; // Updated
    fltSquare2[50] = -24793; // Updated
    fltSquare2[51] = -25069; // Updated
    fltSquare2[52] = -25141; // Updated
    fltSquare2[53] = -25213; // Updated
    fltSquare2[54] = -25279; // Updated
    fltSquare2[55] = -25351; // Updated
    fltSquare2[56] = -25909; // Updated
    fltSquare2[57] = -26599; // Updated
    fltSquare2[58] = -28117; // Updated
    fltSquare2[59] = -28651; // Updated
    fltSquare2[60] = -29427; // Updated
    fltSquare2[61] = -29935; // Updated
    fltSquare2[62] = -32461; // Updated
    fltSquare2[63] = -33571; // Updated
    fltSquare2[64] = -33877; // Updated
    // Assigning numbers to fltSquare3
    fltSquare3[0] = -1237;
    fltSquare3[1] = -1489;
    fltSquare3[2] = -2383;
    fltSquare3[3] = -2593;
    fltSquare3[4] = -3505;
    fltSquare3[5] = -3691;
    fltSquare3[6] = -4797;
    fltSquare3[7] = 10020;
    fltSquare3[8] = -5707;
    fltSquare3[9] = -5977;
    fltSquare3[10] = -6259;
    fltSquare3[11] = -6811;
    fltSquare3[12] = -6949;
    fltSquare3[13] = -7105;
    fltSquare3[14] = -7231;
    fltSquare3[15] = -7357;
    fltSquare3[16] = -7903;
    fltSquare3[17] = -8455;
    fltSquare3[18] = -9489;   // Added
    fltSquare3[19] = -10117;
    fltSquare3[20] = -10399;
    fltSquare3[21] = -10657;
    fltSquare3[22] = -11227;
    fltSquare3[23] = -11365;
    fltSquare3[24] = -11503;
    fltSquare3[25] = -11653;
    fltSquare3[26] = -11785;
    fltSquare3[27] = -12343;
    fltSquare3[28] = -12883;
    fltSquare3[29] = -14193;  // Added
    fltSquare3[30] = -14833;
    fltSquare3[31] = -15391;
    fltSquare3[32] = -15457;
    fltSquare3[33] = -15535;
    fltSquare3[34] = -16275;
    fltSquare3[35] = -16771;
    fltSquare3[36] = -17317;
    fltSquare3[37] = -18139;
    fltSquare3[38] = -18703;
    fltSquare3[39] = -18775;
    fltSquare3[40] = -18835;
    fltSquare3[41] = -19117;
    fltSquare3[42] = -19405;
    fltSquare3[43] = -19669;
    fltSquare3[44] = -19951;
    fltSquare3[45] = -20227;
    fltSquare3[46] = -20503;
    fltSquare3[47] = -20791;
    fltSquare3[48] = -21055;
    fltSquare3[49] = -23281;
    fltSquare3[50] = -23557;
    fltSquare3[51] = -23827;
    fltSquare3[52] = -24097;
    fltSquare3[53] = -24385;
    fltSquare3[54] = -24655;
    fltSquare3[55] = -24931;
    fltSquare3[56] = -26185;
    fltSquare3[57] = -26737;
    fltSquare3[58] = -26887;
    fltSquare3[59] = -27019;
    fltSquare3[60] = -27151;
    fltSquare3[61] = -27289;
    fltSquare3[62] = -27841;
    fltSquare3[63] = -28393;
    fltSquare3[64] = -29697;  
    fltSquare3[66] = -30271;
    fltSquare3[67] = -30469;
    fltSquare3[68] = -32881;
    fltSquare3[69] = -33877;

    fltSquare4[0] = -7753;   // Updated
    fltSquare4[1] = -8323;   // Updated
    fltSquare4[2] = -9771;   // Updated
    fltSquare4[3] = -12205;  // Updated
    fltSquare4[4] = -12751;  // Updated
    fltSquare4[5] = -14959;  // Updated
    fltSquare4[6] = -15661;  // Updated
    fltSquare4[7] = -16207;  // Updated
    fltSquare4[8] = -16891;  // Updated
    fltSquare4[9] = -17449;  // Updated
    fltSquare4[10] = -18283; // Updated
    fltSquare4[11] = -21343; // Updated
    fltSquare4[12] = -21631; // Updated
    fltSquare4[13] = -21913; // Updated
    fltSquare4[14] = -22183; // Updated
    fltSquare4[15] = -22453; // Updated
    fltSquare4[16] = -22723; // Updated
    fltSquare4[17] = -23017; // Updated
    fltSquare4[18] = -27697; // Updated
    fltSquare4[19] = -28255; // Updated
    fltSquare4[20] = -31183; // Updated
    fltSquare4[21] = -31387; // Updated
    fltSquare4[22] = -31549; // Updated
    fltSquare4[23] = -32767; // Updated

    intSize1[6] = 200;
    intSize1[34] = 200;

    intSize2[12] = 200;
    intSize2[17] = 200;
    intSize2[60] = 200;

    intSize3[18] = 200;
    intSize3[29] = 200;
    intSize3[64] = 200;
    intSize4[2] = 200;
  }
  
  public void draw() {
    if (intPage == 0){
      titleScreen();
    } else if(intPage == 1){
      menu();
    } else if(intPage == 2){
      reset();
    } else if(intPage == 3){
      gameplay();
    } else if(intPage == 4){
        score();
    } else if(intPage == 5){
      tutorial();
    } else if(intPage == 6){
      pauseGame();
    }
  }

  public void keyPressed() {
    if (intPage == 0) {
      if (key == RETURN) {
        intPage = 1;
      }
    } else if (intPage == 1) {
      if (key == BACKSPACE) {
        intPage = 0;
      }
    } else if (intPage == 5 || intPage == 4 || intPage == 6) {
      if (key == BACKSPACE) {
        intPage = 1;
      } else if (intPage == 6) {
        if (key == RETURN) {
          intPage = 3;
        }
      }
    } else if (intPage == 3) {
      if (key == BACKSPACE) {
        intPage = 6;
      }
  
      if (key == '1' && !keyIsPressed1) {
        keyIsPressed1 = true;
        println(closestBlockIndex1 + " square 1");
        if (closestBlockIndex1 != -1 && blnCanPressed1[closestBlockIndex1] && !blnHasPressed1[closestBlockIndex1]) {
          // Check the block's position
          if ((fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1]) > 550 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 650) {
            blnHasPressed1[closestBlockIndex1] = true;
            // No points awarded for this zone
          } else if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 650 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 700) {
            blnHasPressed1[closestBlockIndex1] = true;
            intScore += 5;
          } else if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 700 && fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] < 750) {
            if (intSize1[closestBlockIndex1] < 26) {
              blnHasPressed1[closestBlockIndex1] = true;
            }
            if (intSize1[closestBlockIndex1] > 26) {
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
        println(closestBlockIndex2 + " square 2");
        if (closestBlockIndex2 != -1 && blnCanPressed2[closestBlockIndex2] && !blnHasPressed2[closestBlockIndex2]) {
          // Check the block's position
          if ((fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2]) > 550 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 650) {
            blnHasPressed2[closestBlockIndex2] = true;
            // No points awarded for this zone
          } else if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 650 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 700) {
            blnHasPressed2[closestBlockIndex2] = true;
            intScore += 5;
          } else if (fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] > 700 && fltSquare2[closestBlockIndex2] + intSize2[closestBlockIndex2] < 750) {
            if (intSize2[closestBlockIndex2] < 26) {
              blnHasPressed2[closestBlockIndex2] = true;
            }
            if (intSize2[closestBlockIndex2] > 26) {
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
        println(closestBlockIndex3 + " square 3");
        if (closestBlockIndex3 != -1 && blnCanPressed3[closestBlockIndex3] && !blnHasPressed3[closestBlockIndex3]) {
          // Check the block's position
          if ((fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3]) > 550 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 650) {
            blnHasPressed3[closestBlockIndex3] = true;
            // No points awarded for this zone
          } else if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 650 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 700) {
            blnHasPressed3[closestBlockIndex3] = true;
            intScore += 5;
          } else if (fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] > 700 && fltSquare3[closestBlockIndex3] + intSize3[closestBlockIndex3] < 750) {
            if (intSize3[closestBlockIndex3] < 26) {
              blnHasPressed3[closestBlockIndex3] = true;
            }
            if (intSize3[closestBlockIndex3] > 26) {
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
        println(closestBlockIndex4 + " square 4");
        if (closestBlockIndex4 != -1 && blnCanPressed4[closestBlockIndex4] && !blnHasPressed4[closestBlockIndex4]) {
          // Check the block's position
          if ((fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4]) > 550 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 650) {
            blnHasPressed4[closestBlockIndex4] = true;
            // No points awarded for this zone
          } else if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 650 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 700) {
            blnHasPressed4[closestBlockIndex4] = true;
            intScore += 5;
          } else if (fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] > 700 && fltSquare4[closestBlockIndex4] + intSize4[closestBlockIndex4] < 750) {
            if (intSize4[closestBlockIndex4] < 26) {
              blnHasPressed4[closestBlockIndex4] = true;
            }
            if (intSize4[closestBlockIndex4] > 26) {
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
  }
  
  public void keyReleased() {
    if (intPage == 3) {
      if (key == '1') {
        keyIsPressed1 = false;
        if (closestBlockIndex1 != -1 && blnCanPressed1[closestBlockIndex1] && blnHold1[closestBlockIndex1]) {
          // Ensure the release happens in the green zone
          if (fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] > 700 && fltSquare1[closestBlockIndex1] < 750) {
            // Calculate the percentage of the block that has passed the target zone
            float blockPassed = fltSquare1[closestBlockIndex1] + intSize1[closestBlockIndex1] - 700;
            float blockLength = intSize1[closestBlockIndex1];
            float percentagePassed = blockPassed / blockLength;
            if (intSize1[closestBlockIndex1] > 1) {
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
            if (intSize2[closestBlockIndex2] > 1) {
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
            if (intSize3[closestBlockIndex3] > 1) {
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
            if (intSize4[closestBlockIndex4] > 1) {
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
          }
          blnHold4[closestBlockIndex4] = false;
          blnHasPressed4[closestBlockIndex4] = true;
        }
      }
    }
  }

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

  private void gameplay() {
    if (fltSquare3[69] < 725) {
        audios[0].play(0);  // Play audio with no looping
    } 
    if (fltSquare3[69] > 725) {
        audios[0].stop();
    }

    if (fltSquare3[69] > 1200) {
        intPage = 4;
    }

    background(0);
    image(Virus_background, 0, 0);
    fill(0, 255, 0);
    rect(190, 700, 450, 50);
    
    // Moving squares 1
    for (int i = 0; i < fltSquare1.length; i++) {
        if (!blnHasPressed1[i]) {
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
    if (closestBlockIndex1 != -1) {
        if (blnHold1[closestBlockIndex1] && intSize1[closestBlockIndex1] > 0) {
            intSize1[closestBlockIndex1] -= fltSquareSpeed;
        }
    }
      
    // Moving squares 2
    for (int i = 0; i < fltSquare2.length; i++) {
        if (!blnHasPressed2[i]) {
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
    if (closestBlockIndex2 != -1) {
        if (blnHold2[closestBlockIndex2] && intSize2[closestBlockIndex2] > 0) {
            intSize2[closestBlockIndex2] -= fltSquareSpeed;
        }
    }

    // Moving squares 3
    for (int i = 0; i < fltSquare3.length; i++) {
        if (!blnHasPressed3[i]) {
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

    if (closestBlockIndex3 != -1) {
        if (blnHold3[closestBlockIndex3] && intSize3[closestBlockIndex3] > 0) {
            intSize3[closestBlockIndex3] -= fltSquareSpeed;
        }
    }

    // Moving squares 4
    for (int i = 0; i < fltSquare4.length; i++) {
        if (!blnHasPressed4[i]) {
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
    if (closestBlockIndex4 != -1) {
        if (blnHold4[closestBlockIndex4] && intSize4[closestBlockIndex4] > 0) {
            intSize4[closestBlockIndex4] -= fltSquareSpeed;
        }
    }
    
    // Display the score in the top right corner
    fill(255);
    textSize(20);
    textAlign(RIGHT, TOP);
    text("Score: " + intScore, width - 10, 10);
  }

  private void titleScreen() {
    image(Title, 0, 0);
  }

  private void menu() {
    image(Menu, 0, 0);
    
    if ((mouseX > 50) && (mouseX < 300) && (mouseY > 200) && mouseY < 500) {
        tutorialCover = loadImage("Tutorial.png");
        tutorialCover.resize(300, 350);
        image(tutorialCover, 25, 170);
    } else {
        tutorialCover = loadImage("Tutorial_black.png");
        tutorialCover.resize(250, 300);
        image(tutorialCover, 50, 200);
    }
    
    if ((mouseX > 500) && (mouseX < 750) && (mouseY > 200) && (mouseY < 500)) {
        Virus_cover = loadImage("Virus_cover.jpg");
        Virus_cover.resize(300, 350);
        image(Virus_cover, 475, 175);
    } else {
        Virus_cover = loadImage("Virus_cover_black.jpg");
        Virus_cover.resize(250, 300);
        image(Virus_cover, 500, 200);
    }
    
    if (mousePressed) {
        if ((mouseX > 50) && (mouseX < 300) && (mouseY > 200) && mouseY < 500) {
            intPage = 5;
        } else if ((mouseX > 500) && (mouseX < 750) && (mouseY > 200) && (mouseY < 500)) {
            intPage = 3;
        }
    }
  }

  private void tutorial() {
    image(tutorialLevel, 0, 0);
  }

  private void reset(){
    // Reset arrays for intNotes1
    for (int i = 0; i < intNotes1; i++) {
        blnCanPressed1[i] = false;
        blnHasPressed1[i] = false;
        blnHold1[i] = false;
        intSize1[i] = 25;
    }

    // Reset arrays for intNotes2
    for (int i = 0; i < intNotes2; i++) {
        blnCanPressed2[i] = false;
        blnHasPressed2[i] = false;
        blnHold2[i] = false;
        intSize2[i] = 25;
    }

    // Reset arrays for intNotes3
    for (int i = 0; i < intNotes3; i++) {
        blnCanPressed3[i] = false;
        blnHasPressed3[i] = false;
        blnHold3[i] = false;
        intSize3[i] = 25;
    }

    // Reset arrays for intNotes4
    for (int i = 0; i < intNotes4; i++) {
        blnCanPressed4[i] = false;
        blnHasPressed4[i] = false;
        blnHold4[i] = false;
        intSize4[i] = 25;
    }
    // Assigning numbers to fltSquare1
    fltSquare1[0] = -5485;   // Updated
    fltSquare1[1] = -6607;   // Updated
    fltSquare1[2] = -8875;   // Updated
    fltSquare1[3] = -9937;   // Updated
    fltSquare1[4] = -11023;  // Updated
    fltSquare1[5] = -13309;  // Updated
    fltSquare1[6] = -13447;  // Updated
    fltSquare1[7] = -14557;  // Updated
    fltSquare1[8] = -15115;  // Updated
    fltSquare1[9] = -15793;  // Updated
    fltSquare1[10] = -16345; // Updated
    fltSquare1[11] = -17041; // Updated
    fltSquare1[12] = -17599; // Updated
    fltSquare1[13] = -17671; // Updated
    fltSquare1[14] = -17737; // Updated
    fltSquare1[15] = -17875; // Updated
    fltSquare1[16] = -18433; // Updated
    fltSquare1[17] = -21193; // Updated
    fltSquare1[18] = -21337; // Updated
    fltSquare1[19] = -21475; // Updated
    fltSquare1[20] = -21619; // Updated
    fltSquare1[21] = -21763; // Updated
    fltSquare1[22] = -21889; // Updated
    fltSquare1[23] = -22033; // Updated
    fltSquare1[24] = -22159; // Updated
    fltSquare1[25] = -22309; // Updated
    fltSquare1[26] = -22441; // Updated
    fltSquare1[27] = -22579; // Updated
    fltSquare1[28] = -22711; // Updated
    fltSquare1[29] = -22849; // Updated
    fltSquare1[30] = -22993; // Updated
    fltSquare1[31] = -25627; // Updated
    fltSquare1[32] = -26521; // Updated
    fltSquare1[33] = -28831; // Updated
    fltSquare1[34] = -28939; // Updated
    fltSquare1[35] = -29863; // Updated
    fltSquare1[36] = -32281; // Updated
    fltSquare1[37] = -33355; // Updated
    

    // Assigning numbers to fltSquare2
    fltSquare2[0] = -1237;   // Updated
    fltSquare2[1] = -1489;   // Updated
    fltSquare2[2] = -2383;   // Updated
    fltSquare2[3] = -2587;   // Updated
    fltSquare2[4] = -3505;   // Updated
    fltSquare2[5] = -3691;   // Updated
    fltSquare2[6] = -4597;   // Updated
    fltSquare2[7] = -4789;   // Updated
    fltSquare2[8] = -5557;   // Updated
    fltSquare2[9] = -6679;   // Updated
    fltSquare2[10] = -8185;  // Updated
    fltSquare2[11] = -8737;  // Updated
    fltSquare2[12] = -9231;  // Updated
    fltSquare2[13] = -10003; // Updated
    fltSquare2[14] = -11113; // Updated
    fltSquare2[15] = -12613; // Updated
    fltSquare2[16] = -13165; // Updated
    fltSquare2[17] = 900; // Updated
    fltSquare2[18] = -14683; // Updated
    fltSquare2[19] = -15241; // Updated
    fltSquare2[20] = -15943; // Updated
    fltSquare2[21] = -16489; // Updated
    fltSquare2[22] = -16561; // Updated
    fltSquare2[23] = -16639; // Updated
    fltSquare2[24] = -17179; // Updated
    fltSquare2[25] = -18007; // Updated
    fltSquare2[26] = -18565; // Updated
    fltSquare2[27] = -18979; // Updated
    fltSquare2[28] = -19117; // Updated
    fltSquare2[29] = -19273; // Updated
    fltSquare2[30] = -19411; // Updated
    fltSquare2[31] = -19549; // Updated
    fltSquare2[32] = -19669; // Updated
    fltSquare2[33] = -19819; // Updated
    fltSquare2[34] = -19951; // Updated
    fltSquare2[35] = -20089; // Updated
    fltSquare2[36] = -20227; // Updated
    fltSquare2[37] = -20371; // Updated
    fltSquare2[38] = -20503; // Updated
    fltSquare2[39] = -20653; // Updated
    fltSquare2[40] = -20803; // Updated
    fltSquare2[41] = -20923; // Updated
    fltSquare2[42] = -21061; // Updated
    fltSquare2[43] = -23131; // Updated
    fltSquare2[44] = -23269; // Updated
    fltSquare2[45] = -23425; // Updated
    fltSquare2[46] = -23689; // Updated
    fltSquare2[47] = -23977; // Updated
    fltSquare2[48] = -24241; // Updated
    fltSquare2[49] = -24523; // Updated
    fltSquare2[50] = -24793; // Updated
    fltSquare2[51] = -25069; // Updated
    fltSquare2[52] = -25141; // Updated
    fltSquare2[53] = -25213; // Updated
    fltSquare2[54] = -25279; // Updated
    fltSquare2[55] = -25351; // Updated
    fltSquare2[56] = -25909; // Updated
    fltSquare2[57] = -26599; // Updated
    fltSquare2[58] = -28117; // Updated
    fltSquare2[59] = -28651; // Updated
    fltSquare2[60] = -29427; // Updated
    fltSquare2[61] = -29935; // Updated
    fltSquare2[62] = -32461; // Updated
    fltSquare2[63] = -33571; // Updated
    fltSquare2[64] = -33877; // Updated
    // Assigning numbers to fltSquare3
    fltSquare3[0] = -1237;
    fltSquare3[1] = -1489;
    fltSquare3[2] = -2383;
    fltSquare3[3] = -2593;
    fltSquare3[4] = -3505;
    fltSquare3[5] = -3691;
    fltSquare3[6] = -4797;
    fltSquare3[7] = 10020;
    fltSquare3[8] = -5707;
    fltSquare3[9] = -5977;
    fltSquare3[10] = -6259;
    fltSquare3[11] = -6811;
    fltSquare3[12] = -6949;
    fltSquare3[13] = -7105;
    fltSquare3[14] = -7231;
    fltSquare3[15] = -7357;
    fltSquare3[16] = -7903;
    fltSquare3[17] = -8455;
    fltSquare3[18] = -9489;   // Added
    fltSquare3[19] = -10117;
    fltSquare3[20] = -10399;
    fltSquare3[21] = -10657;
    fltSquare3[22] = -11227;
    fltSquare3[23] = -11365;
    fltSquare3[24] = -11503;
    fltSquare3[25] = -11653;
    fltSquare3[26] = -11785;
    fltSquare3[27] = -12343;
    fltSquare3[28] = -12883;
    fltSquare3[29] = -14193;  // Added
    fltSquare3[30] = -14833;
    fltSquare3[31] = -15391;
    fltSquare3[32] = -15457;
    fltSquare3[33] = -15535;
    fltSquare3[34] = -16275;
    fltSquare3[35] = -16771;
    fltSquare3[36] = -17317;
    fltSquare3[37] = -18139;
    fltSquare3[38] = -18703;
    fltSquare3[39] = -18775;
    fltSquare3[40] = -18835;
    fltSquare3[41] = -19117;
    fltSquare3[42] = -19405;
    fltSquare3[43] = -19669;
    fltSquare3[44] = -19951;
    fltSquare3[45] = -20227;
    fltSquare3[46] = -20503;
    fltSquare3[47] = -20791;
    fltSquare3[48] = -21055;
    fltSquare3[49] = -23281;
    fltSquare3[50] = -23557;
    fltSquare3[51] = -23827;
    fltSquare3[52] = -24097;
    fltSquare3[53] = -24385;
    fltSquare3[54] = -24655;
    fltSquare3[55] = -24931;
    fltSquare3[56] = -26185;
    fltSquare3[57] = -26737;
    fltSquare3[58] = -26887;
    fltSquare3[59] = -27019;
    fltSquare3[60] = -27151;
    fltSquare3[61] = -27289;
    fltSquare3[62] = -27841;
    fltSquare3[63] = -28393;
    fltSquare3[64] = -29697;  
    fltSquare3[66] = -30271;
    fltSquare3[67] = -30469;
    fltSquare3[68] = -32881;
    fltSquare3[69] = -33877;

    fltSquare4[0] = -7753;   // Updated
    fltSquare4[1] = -8323;   // Updated
    fltSquare4[2] = -9771;   // Updated
    fltSquare4[3] = -12205;  // Updated
    fltSquare4[4] = -12751;  // Updated
    fltSquare4[5] = -14959;  // Updated
    fltSquare4[6] = -15661;  // Updated
    fltSquare4[7] = -16207;  // Updated
    fltSquare4[8] = -16891;  // Updated
    fltSquare4[9] = -17449;  // Updated
    fltSquare4[10] = -18283; // Updated
    fltSquare4[11] = -21343; // Updated
    fltSquare4[12] = -21631; // Updated
    fltSquare4[13] = -21913; // Updated
    fltSquare4[14] = -22183; // Updated
    fltSquare4[15] = -22453; // Updated
    fltSquare4[16] = -22723; // Updated
    fltSquare4[17] = -23017; // Updated
    fltSquare4[18] = -27697; // Updated
    fltSquare4[19] = -28255; // Updated
    fltSquare4[20] = -31183; // Updated
    fltSquare4[21] = -31387; // Updated
    fltSquare4[22] = -31549; // Updated
    fltSquare4[23] = -32767; // Updated

    intSize1[6] = 200;
    intSize1[34] = 200;

    intSize2[12] = 200;
    intSize2[17] = 200;
    intSize2[60] = 200;

    intSize3[18] = 200;
    intSize3[29] = 200;
    intSize3[64] = 200;
    intSize4[2] = 200;

    // hold blocks
    String[] audioPaths = { "Level1.wav" };  // Adjust based on your audio file location
    audios = Audio.initializeAudioArray(audioPaths);
    intPage = 3;
  }

  private void score(){
    image(Score,0, 0);
    fill(0);
    textSize(100);
    text(intScore, 500, 300);
  }
   private void pauseGame(){
     audios[0].stop();
    image(PauseGameImage, 0, 0);
  }
  
}
