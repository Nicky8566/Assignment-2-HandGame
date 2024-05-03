package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Main.Difficulty;

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
        System.err.println("Something went wrong!");
        System.exit(0);
    }
    return null;
  }
}
