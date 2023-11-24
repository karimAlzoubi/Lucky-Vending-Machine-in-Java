import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner input = new Scanner(System.in);
        String stput;
        int intput = 0;

        do {
            game.displayMenu();
            System.out.print("Choose an option (1/2/3/4/5): ");
            stput = input.next();
            try {
                intput = Integer.parseInt(stput);
                if (intput >= 1 && intput <= 5) {
                    switch (intput) {
                        case 1:
                            game.startGame();
                            break;
                        case 2:
                            game.guessPrize();
                            break;
                        case 3:
                            game.yourPrizes();
                            break;
                        case 4:
                            game.gameHelp();
                            break;
                        case 5:
                        	System.out.println("Goodbye!");
                        	game.endGame();
                            break;
                    }
                } else {
                    System.out.println("Error: Please enter a valid option (1/2/3/4/5).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. You can't enter letters, Please enter a valid option (1/2/3/4/5).");
            }
        } while (true);
    }   
}