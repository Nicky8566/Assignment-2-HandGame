package nz.ac.auckland.se281.strategy;

public class StrategyChanger {
  private Strategy strategy;

  /**
   * Constructor for the StrategyChanger class.
   *
   * @param strategy the strategy to be used.
   */
  public StrategyChanger(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * This method sets the strategy to be used.
   *
   * @param strategy the strategy to be used.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * This method returns the strategy to be used.
   *
   * @return the strategy to be used.
   */
  public Strategy getStrategy() {
    return this.strategy;
  }

  /**
   * This method processes the strategy.
   *
   * @return the number of fingers the bot will play.
   */
  public int process() {
    return strategy.execute();
  }
}
