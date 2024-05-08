package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.TopStrat;

public class Medium extends LevelDifficulty {
  public int numberFingers() {

    if (rounds >= 4) {
      strategy.setStrategy(new TopStrat());

      return strategy.process();
    } else {
      excuteRandStrat();
    }
    return strategy.process();
  }
}
