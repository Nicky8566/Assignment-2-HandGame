package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Utils;

public class Easy implements LevelDifficulty {
  // testing something

  public int numberFingers() {
    // return a random number between 1 and 5
    return Utils.getRandomNumberRange(0, 5);
  }
}
