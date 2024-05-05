package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.RandomStrat;
// importat array list and list
import nz.ac.auckland.se281.strategy.StrategyChanger;
import nz.ac.auckland.se281.strategy.TopStrat;

public class Hard implements LevelDifficulty {
  // current strategy
  private static int rounds = 0;
  private static String botsResult = null;

  public int numberFingers() {
    rounds++;
    StrategyChanger strategy = new StrategyChanger(new RandomStrat());
    if (rounds >= 4) {
      if (botsResult == "lost" && strategy.getStrategy() instanceof TopStrat) {
        strategy.setStrategy(new RandomStrat());
      }
      if (botsResult == "lost" && strategy.getStrategy() instanceof RandomStrat) {
        strategy.setStrategy(new TopStrat());
      }
    }
    return strategy.process();
  }

  public static void resetRounds() {
    rounds = 0;
  }

  public static void setBotResultS(String result) {
    botsResult = result;
  }
}
