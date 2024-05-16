package nz.ac.auckland.se281.difficulty;

public class Easy extends LevelDifficulty {
  /**
   * This method returns the number of fingers the bot will play on the easy difficulty. The bot
   * will play randomly.
   *
   * @return the number of fingers the bot will play.
   */
  @Override
  public int numberFingers() {
    return strategy.process();
  }
}
