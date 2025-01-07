package section1;

public class NumberThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 9; i++) {
			try {
				Thread.sleep(99);
				System.out.print(i + " ");
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted.");
			}
		}
	}
	
}
