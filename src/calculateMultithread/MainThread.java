package calculateMultithread;

import java.util.Scanner;

public class MainThread {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap n");
		int n = scanner.nextInt();
		
		CalculateThread thread1 = new CalculateThread(n);
		Thread thread2 = new Thread(new CalculateRunnable(n));
		
		thread1.start();
		thread2.start();
		
		scanner.close();
	}
	
	public static class CalculateThread extends Thread {
		int n;
		
		public CalculateThread(int n) {
			super();
			this.n = n;
		}

		@Override
		public void run() {
			super.run();
			System.out.println("Ket qua n!: " + getFractional(n));
		}
		
		private int getFractional(int n) {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
			return result;
		}
	}

	public static class CalculateRunnable implements Runnable {
		int n;
		
		public CalculateRunnable(int n) {
			super();
			this.n = n;
		}

		@Override
		public void run() {
			System.out.println("Ket qua 1 - n: " + sum(n));
		}
		
		private int sum(int n) {
			int sum = 0;
			
			for(int i = 1; i <= n; i++) {
	            // sum = sum + i;
	            sum += i;
	        }
			
			return sum;
		}
	}
}
