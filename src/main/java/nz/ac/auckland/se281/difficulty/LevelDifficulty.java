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

  /**
   * This method sets the number of rounds the bot has played.
   *
   * @param round the number of rounds the bot has played.
   */
  public void setRounds(int round) {
    rounds = round;
  }

  /** This method resets the number of rounds the bot has played. */
  public void resetRounds() {
    rounds = 0;
  }

  /**
   * This method sets the result of the bot.
   *
   * @param result the result of the bot.
   */
  public void setBotResultS(String result) {
    botsResult = result;
  }

  /**
   * This method sets up the top strategy of the bot.
   *
   * @param oddOrEven the choice of odd or even.
   * @param numberFingers the number of fingers the player will play.
   */
  public void giveTopInfo(Choice oddOrEven, String numberFingers) {
    // adds players number of fingers to history
    topStrat.addPlayerNum(Integer.parseInt(numberFingers));
    // players choise of odd or even to win
    topStrat.setOddOrEven(oddOrEven);
  }

  /** This method resets the top strategy history of the players chosen fingers. */
  public void resetTopInfo() {
    topStrat.resetHistory();
  }

  /**
   * This method returns the number of fingers the bot will play on the difficulty.
   *
   * @return the number of fingers the bot will play.
   */
  public abstract int numberFingers();
}
