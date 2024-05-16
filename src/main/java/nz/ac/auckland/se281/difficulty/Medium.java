package nz.ac.auckland.se281.difficulty;

public class Medium extends LevelDifficulty {
  /**
   * This method returns the number of fingers the bot will play on the medium difficulty.
   *
   * @return the number of fingers the bot will play.
   */
  @Override
  public int numberFingers() {

    if (rounds >= 4) {
      strategy.setStrategy(topStrat);
      return strategy.process();
    }
    return strategy.process();
  }
}
