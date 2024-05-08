package nz.ac.auckland.se281.strategy;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

public class TopStrat extends Strategy {

  @Override
  public int execute() {
    System.out.println(history);
    System.out.println(oddOrEven);
    System.out.println(even);
    System.out.println(even);

    // check if the players history has more odd or even numbers in it
    for (int i = 0; i < history.size(); i++) {
      if (history.get(i) % 2 == 0) {
        even++;
      }
      if (history.get(i) % 2 != 0) {
        odd++;
      }
    }

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
}
