package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.RandomStrat;
import nz.ac.auckland.se281.strategy.StrategyChanger;
import nz.ac.auckland.se281.strategy.TopStrat;

public class Medium implements LevelDifficulty {
  // testing something
  private static int rounds = 0;

  public int numberFingers() {
    rounds++;
    StrategyChanger strategy = new StrategyChanger(new RandomStrat());
    if (rounds >= 4) {
      strategy.setStrategy(new TopStrat());

      return strategy.process();
    }
    return strategy.process();
  }
}
