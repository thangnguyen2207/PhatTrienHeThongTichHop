package section1;

public class ThreadProperties implements Runnable {
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadProperties());
		thread.start();
	}
	
	@Override
	public void run() {
		// Get the current thread
        Thread currentThread = Thread.currentThread();

        // Display the properties of the current thread
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.threadId());
        System.out.println("Thread Priority: " + currentThread.getPriority());
        System.out.println("Thread State: " + currentThread.getState());
        System.out.println("Is Thread Daemon: " + currentThread.isDaemon());
        
     // Display numbers in one-second intervals
        try {
            for (int i = 1; i <= 10; i++) { // Display numbers from 1 to 10
                System.out.println("Number: " + i);
                Thread.sleep(1000); // Pause for 1 second (1000 milliseconds)
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
	}
}
