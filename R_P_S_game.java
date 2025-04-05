//
import java.util.Scanner;
import java.util.Random;

public class R_P_S_game {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Shall we play rock, paper, or scissors? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes") || response.equals("y")) {
            playGame();
        } else {
            System.out.println("Ok, maybe next time.");
        }
    }

    public static void playGame() {
        while (true) {
            String playerChoice = getPlayerChoice();
            if (playerChoice.isEmpty()) {
                invalidChoice();
                continue;
            }

            if (playerChoice.equals("quit")) {
                decidedNotToPlay();
                break;
            }

            if (!isValidChoice(playerChoice)) {
                invalidChoice();
                continue;
            }

            String computerChoice = getComputerChoice();
            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            if (!askToPlayAgain()) {
                thanksForPlaying();
                break;
            }
        }
    }

    public static String getPlayerChoice() {
        System.out.println("Please enter rock, paper, or scissors (or type 'quit' to exit):");
        return scanner.nextLine().trim().toLowerCase();
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    public static void invalidChoice() {
        System.out.println("You didn't enter rock, paper, or scissors.");
    }

    public static void decidedNotToPlay() {
        System.out.println("I guess you changed your mind. Maybe next time.");
    }

    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = random.nextInt(3);
        return choices[index];
    }

    public static String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Tie game! Both chose " + player + ".";
        } else if (
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))
        ) {
            return "Player: " + player + "\nComputer: " + computer + "\nYou win!";
        } else {
            return "Player: " + player + "\nComputer: " + computer + "\nComputer wins!";
        }
    }

    public static boolean askToPlayAgain() {
        System.out.println("Play again? (yes/no)");
        String again = scanner.nextLine().trim().toLowerCase();
        return again.equals("yes") || again.equals("y");
    }

    public static void thanksForPlaying() {
        System.out.println("Ok, thanks for playing.");
    }
}