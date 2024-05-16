package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.RandomStrat;
import nz.ac.auckland.se281.strategy.TopStrat;

public class Hard extends LevelDifficulty {
  /**
   * This method returns the number of fingers the bot will play on the hard difficulty.
   *
   * @return the number of fingers the bot will play.
   */
  @Override
  public int numberFingers() {
    // first if the rounds are less than 4, then the bot will play randomly
    if (rounds >= 4) {
      // if the bot lost the last round, then the bot will swtich strategy
      if (botsResult == "lost" && strategy.getStrategy() instanceof TopStrat) {
        strategy.setStrategy(new RandomStrat());
      }
      if (botsResult == "lost" && strategy.getStrategy() instanceof RandomStrat) {
        strategy.setStrategy(topStrat);
      }
    }
    return strategy.process();
  }
}
