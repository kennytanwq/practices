import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
		int randomNum = 1 + (int) (Math.random()*100);
		int playerInput = 0;
		int guessCounter = 0;
		
		startGame();
		
		while (playerInput != randomNum) {
			String guess = JOptionPane.showInputDialog(null, "Enter a number between 1 and 100: ", "Number Guessing Game", 3);
			playerInput = Integer.parseInt(guess);
			JOptionPane.showMessageDialog(null, ""+ resultOfGuess(playerInput, randomNum, guessCounter));
			guessCounter++;
		}
		
	}
	
	public static void startGame() {
		System.out.println("Welcome to the Number Guessing Game!");
	}
	
	public static String resultOfGuess(int playerInput, int randomNum, int guessCounter) {
		if ((playerInput < 1) || (playerInput > 100)) {
			return "Please only enter a number between 1 and 100";
		}
		else if (playerInput == randomNum) {
			return "Congratulations! You've guessed the right number!\nTotal Guesses Made: " + guessCounter;
		}
		else if (playerInput > randomNum) {
			return "Your number is too high!";
		}
		else if (playerInput < randomNum) {
			return "Your number is too low!";
		}
		else {
			return "Your guess is incorrect!\nEnter a number: ";
		}
	}

}
