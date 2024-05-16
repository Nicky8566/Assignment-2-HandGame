package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulty.DifficultyFactory;
import nz.ac.auckland.se281.difficulty.LevelDifficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String playerName;
  private String numberFingers;
  private Difficulty howDifficult;
  private Choice oddOrEven;
  private int playersWins = 0;
  private int playersLoses = 0;
  private int botWins = 0;
  private int botloses = 0;
  private LevelDifficulty diff;

  /**
   * This method is used to start a new game using all the parameters. It intializes everything
   * needed for the game to start.
   *
   * @param difficulty the difficulty the player wants to play on
   * @param choice the choice of odd or even the player wants to play to win for
   * @param options the options for the game (includes the name of the player)
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    if (playerName != null) {
      reset();
    }
    playerName = options[0];
    howDifficult = difficulty;
    oddOrEven = choice;
    diff = DifficultyFactory.chooseDifficulty(howDifficult);
  }

  /**
   * This method is used to play the game. It goes through the game logic and prints the outcome.
   */
  public void play() {
    // check if they instialzed a new game
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    round++;
    // print start round meesage
    MessageCli.START_ROUND.printMessage(String.format("%d", round));
    // print ask input meesage
    MessageCli.ASK_INPUT.printMessage();
    // go through a while loop until the input is correct
    while (true) {
      String input = Utils.scanner.nextLine();
      if (Utils.isInteger(input)) {
        int fingers = Integer.parseInt(input);
        if (fingers >= 0 && fingers <= 5) {
          numberFingers = input;
          break;
        }
      }
      // print error meesage
      MessageCli.INVALID_INPUT.printMessage();
    }

    // assigning difficulty level for the bot to pick its number
    diff.giveTopInfo(oddOrEven, numberFingers);
    diff.setRounds(round);
    int botNumber = diff.numberFingers();

    // print info hand meesage
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, numberFingers);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.format("%d", botNumber));
    int sum = Integer.parseInt(numberFingers) + botNumber;

    // picking the winnger if the sum is even or odd and the player choice is even or odd
    if ((sum % 2 == 0 && oddOrEven == Choice.EVEN) || (sum % 2 != 0 && oddOrEven == Choice.ODD)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.format("%d", sum), oddOrEven.toString(), playerName);
      diff.setBotResultS("lost");
      playersWins++;
      botloses++;

    } else {
      Choice opponentChoice = (oddOrEven == Choice.EVEN) ? Choice.ODD : Choice.EVEN;
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.format("%d", sum), opponentChoice.toString(), "HAL-9000");
      diff.setBotResultS("won");
      playersLoses++;
      botWins++;
    }
  }

  /** This method is used to end the game. It prints the final outcome of the game. */
  public void endGame() {
    // check if they instialzed a new game
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // print the stats of the game
    showStats();
    // print the winner of the game
    if (playersWins > botWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playersWins < botWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    // reset the game
    reset();
  }

  /**
   * This method is used to show the stats of the game. It prints the number of wins and loses for
   * the player and the bot.
   */
  public void showStats() {
    // checking if player has even started a new game
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // print player wins meesage
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.format("%d", playersWins), String.format("%d", playersLoses));
    // print bot wins meesage
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.format("%d", botWins), String.format("%d", botloses));
  }

  /** This method is used to reset the game. It resets all the variables to their initial state. */
  public void reset() {
    // reset history and rounds for top strategy
    diff.resetTopInfo();
    diff.resetRounds();
    // reset rounds and player stats
    round = 0;
    playerName = null;
    numberFingers = null;
    howDifficult = null;
    oddOrEven = null;
    // reset player and bot wins and loses
    playersWins = 0;
    playersLoses = 0;
    botWins = 0;
    botloses = 0;
  }
}
