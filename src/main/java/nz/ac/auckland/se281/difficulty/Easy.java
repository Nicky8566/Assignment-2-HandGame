package nz.ac.auckland.se281.difficulty;

import java.util.Random;

public class Easy implements LevelDifficulty {
  // testing something
  public int numberFingers() {
    Random random = new Random();
    return random.nextInt(6);
  }
}
