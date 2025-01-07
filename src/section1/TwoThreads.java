package section1;

public class TwoThreads {
	public static void main(String[] args) {
		Thread number = new Thread(new NumberThread());
		Thread alphabet = new Thread(new LetterThread());
		
		number.start();
		alphabet.start();
	}
}
