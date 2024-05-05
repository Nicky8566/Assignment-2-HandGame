package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulty.DifficultyFactory;
import nz.ac.auckland.se281.difficulty.Hard;
import nz.ac.auckland.se281.difficulty.LevelDifficulty;
import nz.ac.auckland.se281.difficulty.Medium;
import nz.ac.auckland.se281.strategy.TopStrat;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String playerName;
  private String numberFingers;
  private Difficulty howDiffcult;
  private Choice oddOrEven;
  private TopStrat topStrat = new TopStrat();
  private static int playersWins = 0;
  private static int playersLoses = 0;
  private static int botWins = 0;
  private static int botloses = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    howDiffcult = difficulty;
    oddOrEven = choice;
    topStrat.resetHistory();
    Medium.resetRounds();
    Hard.resetRounds();
    round = 0;
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

    // adds number of fingers to the history
    topStrat.addPlayerNum(Integer.parseInt(numberFingers));
    topStrat.setOddOrEven(oddOrEven);

    // assigning difficulty level for the bot to pick its number
    LevelDifficulty diff = DifficultyFactory.chooseDifficulty(howDiffcult);
    int botNumber = diff.numberFingers();

    // print info hand meesage
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, numberFingers);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.format("%d", botNumber));
    int sum = Integer.parseInt(numberFingers) + botNumber;

    // picking the winnger if the sum is even or odd and the player choice is even or odd
    if ((sum % 2 == 0 && oddOrEven == Choice.EVEN) || (sum % 2 != 0 && oddOrEven == Choice.ODD)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.format("%d", sum), oddOrEven.toString(), playerName);
      Hard.setBotResultS("lost");
      playersWins++;
      botloses++;

    } else {
      Choice opponentChoice = (oddOrEven == Choice.EVEN) ? Choice.ODD : Choice.EVEN;
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.format("%d", sum), opponentChoice.toString(), "HAL-9000");
      Hard.setBotResultS("won");
      playersLoses++;
      botWins++;
    }
  }

  public void endGame() {
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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
}
