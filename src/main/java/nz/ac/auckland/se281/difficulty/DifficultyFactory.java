package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.MessageCli;

/**
 * Factory class to create the difficulty level. This will depend on the user's choice of
 * difficulty.
 */
public class DifficultyFactory {
  public static LevelDifficulty chooseDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new Hard();

      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    return null;
  }
}
