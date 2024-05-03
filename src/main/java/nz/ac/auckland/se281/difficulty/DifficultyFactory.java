package nz.ac.auckland.se281.difficulty;

public class DifficultyFactory {
  public static LevelDifficulty chooseDifficulty(String difficulty) {
    switch (difficulty) {
      case "E":
        return new Easy();

      case "M":
        return new Medium();

      case "H":
        return new Hard();

      default:
        System.err.println("Something went wrong!");
        System.exit(0);
    }
    return null;
  }
}
