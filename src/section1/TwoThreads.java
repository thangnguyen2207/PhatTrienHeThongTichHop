package section1;

public class TwoThreads {
	public static void main(String[] args) {
		Thread number = new Thread(new NumberThread());
		Thread alphabet = new Thread(new LetterThread());
		
		number.start();
		alphabet.start();
	}
	
	private static class LetterThread implements Runnable {
		
		@Override
		public void run() {
			for (char c = 'A'; c <= 'K'; c++) {
				try {
					Thread.sleep(200);
					System.out.print(c + " ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class NumberThread implements Runnable {
		
		@Override
		public void run() {
			for (int i = 0; i <= 9; i++) {
				try {
					Thread.sleep(99);
					System.out.print(i + " ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
