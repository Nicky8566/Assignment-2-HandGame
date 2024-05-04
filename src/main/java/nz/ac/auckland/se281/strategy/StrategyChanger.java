package nz.ac.auckland.se281.strategy;

public class StrategyChanger {
  private Strategy strategy;

  public StrategyChanger(Strategy strategy) {
    this.strategy = strategy;

  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int process() {
    return strategy.execute();
  }
}
