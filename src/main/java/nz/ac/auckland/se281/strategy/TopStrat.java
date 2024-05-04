package nz.ac.auckland.se281.strategy;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

public class TopStrat implements Strategy {
  // create array list
  private static List<Integer> history = new ArrayList<>();
  private int odd = 0;
  private int even = 0;
  private static Choice oddOrEven;

  public int execute() {
    // check if the players history has more odd or even numbers in it
    for (int i = 0; i < history.size(); i++) {
      if (history.get(i) % 2 == 0) {
        even++;
      }
      if (history.get(i) % 2 != 0) {
        odd++;
      }
    }
    System.out.println("The odd and even is: " + odd + even);
    System.out.println("The odd and even is: " + oddOrEven);

    if (oddOrEven == Choice.EVEN && even > odd || oddOrEven == Choice.ODD && odd > even) {
      // if there are more even numbers return 10
      return Utils.getRandomOddNumber();
    }

    if (oddOrEven == Choice.EVEN && odd > even || oddOrEven == Choice.ODD && even > odd) {
      // if there are more even numbers return 10
      return Utils.getRandomEvenNumber();
    }
    if (odd == even) {
      return Utils.getRandomNumberRange(0, 5);
    }
    // TO TELL ME IT WAS AN ERROR
    return 35505;
  }

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
