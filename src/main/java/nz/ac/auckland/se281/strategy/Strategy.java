package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public abstract class Strategy {
  // create array list
  protected List<Integer> history = new ArrayList<>();
  protected int odd = 0;
  protected int even = 0;
  protected Choice oddOrEven;

  public abstract int execute();

  public void addPlayerNum(int num) {
    history.add(num);
  }

  public void setOddOrEven(Choice choice) {
    oddOrEven = choice;
  }

  public void resetHistory() {
    history.clear();
    odd = 0;
    even = 0;
    oddOrEven = null;
  }
}
