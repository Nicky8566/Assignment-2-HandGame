package nz.ac.auckland.se281.difficulty;

public class Medium extends LevelDifficulty {
  public int numberFingers() {

    if (rounds >= 4) {
      strategy.setStrategy(topStrat);

      return strategy.process();
    } else {
      excuteRandStrat();
    }
    return strategy.process();
  }
}
