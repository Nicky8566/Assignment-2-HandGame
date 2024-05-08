package nz.ac.auckland.se281.difficulty;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.strategy.RandomStrat;
import nz.ac.auckland.se281.strategy.StrategyChanger;
import nz.ac.auckland.se281.strategy.TopStrat;

public abstract class LevelDifficulty {
  protected StrategyChanger strategy = new StrategyChanger(new RandomStrat());
  protected TopStrat topStrat = new TopStrat();
  protected int rounds = 0;
  protected String botsResult = null;

  public int excuteRandStrat() {
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

  public void giveTopInfo(Choice oddOrEven, String numberFingers) {
    topStrat.addPlayerNum(Integer.parseInt(numberFingers));
    topStrat.setOddOrEven(oddOrEven);
  }

  public void resetTopInfo() {
    topStrat.resetHistory();
  }

  public abstract int numberFingers();
}
