package section1;

public class LetterThread implements Runnable {
	@Override
	public void run() {
		for (char c = 'A'; c <= 'K'; c++) {
			try {
				Thread.sleep(200);
				System.out.print(c + " ");
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted.");
			}
		}
	}
}
