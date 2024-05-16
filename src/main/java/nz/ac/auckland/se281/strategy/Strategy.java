package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public abstract class Strategy {
  protected List<Integer> history = new ArrayList<>();
  protected int odd = 0;
  protected int even = 0;
  protected Choice oddOrEven;

  /**
   * This method returns a number between 1 and 5 depending on the strategy.
   *
   * @return a number between 1 and 5.
   */
  public abstract int execute();

  /**
   * This method adds the number of fingers the player has played to the history.
   *
   * @param num the number of fingers the player has played.
   */
  public void addPlayerNum(int num) {
    history.add(num);
  }

  /**
   * This method sets the choice of odd or even the player has chosen.
   *
   * @param choice the choice of odd or even the player has chosen.
   */
  public void setOddOrEven(Choice choice) {
    oddOrEven = choice;
  }

  /**
   * This method resets the history of the players chosen fingers, the choice of odd or even the
   * player has chosen and the odd and even counter to null.
   */
  public void resetHistory() {
    resetEvenOdd();
    history.clear();
    oddOrEven = null;
  }

  /** This method resets the odd and even counter to 0. */
  public void resetEvenOdd() {
    even = 0;
    odd = 0;
  }
}
