package calculateMultithread;

import java.util.Scanner;

public class mainThread {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		CalculateThread thread1 = new CalculateThread();
		Thread thread2 = new Thread(new CalculateRunnable());
		
		thread1.run();
//		thread2.run();
	}
	
	public static class CalculateThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println("Nhap n");
			int n = scanner.nextInt();
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
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Nhap n");
			int n = scanner.nextInt();
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
