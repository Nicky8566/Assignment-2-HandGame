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

  public void endGame() {
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    showStats();
    if (playersWins > botWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playersWins < botWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    reset();
  }

  public void showStats() {
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.format("%d", playersWins), String.format("%d", playersLoses));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.format("%d", botWins), String.format("%d", botloses));
  }

  public void reset() {
    diff.resetTopInfo();
    round = 0;
    playerName = null;
    numberFingers = null;
    howDifficult = null;
    oddOrEven = null;
    playersWins = 0;
    playersLoses = 0;
    botWins = 0;
    botloses = 0;
  }
}
