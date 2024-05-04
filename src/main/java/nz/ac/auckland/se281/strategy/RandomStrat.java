package nz.ac.auckland.se281.strategy;

import nz.ac.auckland.se281.Utils;

public class RandomStrat implements Strategy {
  public int execute() {
    // return a random number between 1 and 5
    return Utils.getRandomNumberRange(0, 5);
  }
}
