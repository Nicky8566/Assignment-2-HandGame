package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.MessageCli;

public class DifficultyFactory {
  /**
   * This method chooses the difficulty of the game.
   *
   * @param difficulty the difficulty of the game.
   * @return the difficulty of the game.
   */
  public static LevelDifficulty chooseDifficulty(Difficulty difficulty) {
    // choose the difficulty of the game
    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new Hard();
        // if the difficulty is invalid, then print an error message and exit the game
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    // return null if the difficulty is invalid
    return null;
  }
}
