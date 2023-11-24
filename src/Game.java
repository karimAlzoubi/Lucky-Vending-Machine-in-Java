
import java.util.*;
import java.io.Serializable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


class Game  {
	public Player player;
    private LuckyGuessGenerator guessGenerator;
    private List<Prize> prizesList;
    private boolean gameRunning;
    
    public Game() {
        player = null;
        guessGenerator = new LuckyGuessGenerator();
        
        prizesList = new ArrayList<>(); 
        prizesList.add(new Prize(1, "Pen", 1, 10));
        prizesList.add(new Prize(2, "Book", 2, 20));
        prizesList.add(new Prize(3, "DVD", 3, 30));
        prizesList.add(new Prize(4, "Mouse", 4, 40));
        prizesList.add(new Prize(5, "Keyboard", 5, 50));
        
    }	
    public void displayMenu() {
        System.out.println("\nWelcome to the Lucky Vending Machine");
        System.out.println("==================================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Guess A Prize ");
        System.out.println("(3) What Have I Won So Far?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game ");
    
	}
    public void startGame() {
        if (player == null) {
            Scanner input = new Scanner(System.in);
            String playerName;

            while (true) {
                System.out.print("Enter your name: ");
                playerName = input.nextLine().trim(); // Trim to remove leading and trailing white spaces
                if (playerName != "") {
                    break; 
                }
                System.out.println("Player name cannot be empty. Please try again.");
            }

            player = new Player(playerName);
            System.out.println("Welcome, " + playerName + "! You have started a new game.");
            gameRunning = true;
        } else {
            System.out.println("A game is already in progress. You can't start a new one.");
        }
    }
    
    public void guessPrize() {
        if (gameRunning == false) {
            System.out.println("Please start a new game first.");
            return;
        }

        Scanner input = new Scanner(System.in);
        int guessCost;

        while (true) {
            System.out.print("Enter the amount you want to spend (1-5): ");
            
            if (input.hasNextInt()) {
                guessCost = input.nextInt();
                
                if (guessCost >= 1 && guessCost <= 5) {
                    break;
                } else {
                    System.out.println("Error: Your guess must be number between 1-5.\n");
                }
            } else {
                System.out.println("Error: Please enter a valid number between 1-5, you can't enter a letters.\n");
                input.next();  // Clear the invalid input from the scanner, so the loop doesn't repeated
            }
        }

        int luckyNumber = guessGenerator.generateLuckyNumber();

        System.out.println("Your Guess : " + guessCost);
        System.out.println("My Guess : " + luckyNumber);

        if (guessCost == luckyNumber) {
            player.increaseTotalSpent(guessCost);
            player.addPrize(prizesList.get(guessCost - 1));
            Prize wonPrize = prizesList.get(guessCost - 1);
            System.out.println("Congratulations! You have won a " + wonPrize.getPrizeName() + ", Worth $" + wonPrize.getPrizeWorth());
        } else {
            player.increaseTotalSpent(guessCost);
            System.out.println("Sorry! You have won absolutely NOTHING! Please try again.");
        }
    }    public void yourPrizes () {
        if (gameRunning == true ) {
        System.out.println("\nPlayer " +player.getName()+" has won these prizes: ");
        int totalWorth = 0;
        for (Prize prize : player.getPrizesWon()) {
            System.out.print(prize.getPrizeName() +" ");
            totalWorth += prize.getPrizeWorth(); 
        }
        System.out.println("\nworth a total $"+totalWorth);
        System.out.println("Total amount spent is $"+ player.getTotalSpent());
        }
        else {
            System.out.println("No game in progress. Start a new game to view Your Prizes");
        }
    }
    
    public void endGame() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lastPlayer.txt", false))) {
            writer.write("Player Name: " + player.getName() + "\n");
            writer.write("Prizes Won:\n");
            for (Prize prize : player.getPrizesWon()) {
                writer.write(prize.getPrizeName() + ", Cost: $" + prize.getPrizeCost() + ", Worth: $" + prize.getPrizeWorth() + "\n");
            }
            writer.write("The total spent is: $" + player.getTotalSpent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    
    public void gameHelp() {
    	System.out.println("\nThe Lucky Vending Machine is a unique and entertaining game that combines the thrill of gambling with the excitement of winning prizes.");
    	System.out.println("To start the game you must identify a player in option (1)");
    	System.out.println("To start guessing with the computer you have to choose the option (2)");
    	System.out.println("The machine then generates a random 'lucky number,' and if your guess matches the lucky number, you win a prize!\nEach guess corresponds to a specific prize, and the higher your guess, the more valuable the potential prize.");
    }

}

