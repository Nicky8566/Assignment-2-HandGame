package nz.ac.auckland.se281.difficulty;

public class difficultyFactory {
  public static difficulty chooseDifficulty(String difficulty) {
    switch (difficulty) {
      case "E":
        return new easy();

      case "M":
        return new medium();

      case "H":
        return new hard();

      default:
        System.err.println("Something went wrong!");
        System.exit(0);
    }
    return null;
  }
}
