package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.strategy.RandomStrat;
import nz.ac.auckland.se281.strategy.StrategyChanger;

public abstract class LevelDifficulty {
  protected StrategyChanger strategy = new StrategyChanger(new RandomStrat());
  protected int rounds = 0;
  protected String botsResult = null;

  public int excuteRandStrat() {
    StrategyChanger strategy = new StrategyChanger(new RandomStrat());
    return strategy.process();
  }

  public void setRounds(int round) {
    rounds = round;
  }

  public void resetRounds() {
    rounds = 0;
  }

  public void setBotResultS(String result) {
    botsResult = result;
  }

  public abstract int numberFingers();
}
