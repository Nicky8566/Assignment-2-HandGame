package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    // print start round meesage
    MessageCli.START_ROUND.printMessage("1");
    // print ask input meesage
    MessageCli.ASK_INPUT.printMessage();
    // go through a while loop until the input is correct
    while (true) {
      String input = Utils.scanner.nextLine();
      if (Utils.isInteger(input)) {
        int fingers = Integer.parseInt(input);
        if (fingers >= 0 && fingers <= 5) {
          break;
        }
      }
      // print error meesage
      MessageCli.INVALID_INPUT.printMessage();
    }
  }

  public void endGame() {}

  public void showStats() {}
}
