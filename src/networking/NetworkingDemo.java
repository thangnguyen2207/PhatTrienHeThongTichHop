package networking;

public class NetworkingDemo {

	public static void main(String[] args) {
		// Thread 1: Fetch data from microsoft.com
		NetworkThread thread1 = new NetworkThread("https://www.microsoft.com/", "Microsoft");
		// Thread 2: Fetch data from iuh.edu.vn
		NetworkThread thread2 = new NetworkThread("https://iuh.edu.vn/", "IUH");
		
		// Start both threads
        thread1.start();
        thread2.start();
        
     // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Both threads have completed execution.");
	}

}
