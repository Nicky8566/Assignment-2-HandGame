package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.RandomStrat;
import nz.ac.auckland.se281.strategy.StrategyChanger;

public class Easy implements LevelDifficulty {
  // testing something

  public int numberFingers(int rounds) {
    StrategyChanger strategy = new StrategyChanger(new RandomStrat());
    return strategy.process();
  }
}
