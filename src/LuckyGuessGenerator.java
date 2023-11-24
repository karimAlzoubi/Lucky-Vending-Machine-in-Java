import java.util.Random;

class LuckyGuessGenerator {
	private Random rand;

    public LuckyGuessGenerator() {
        rand = new Random();
    }

    public int generateLuckyNumber() {
        return rand.nextInt(5) + 1;
    
    }
}
