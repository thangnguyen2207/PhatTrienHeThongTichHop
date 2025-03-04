package chapter2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Section1v4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hostname or website (e.g., example.com): ");
        String hostName = scanner.nextLine();
        scanner.close();
        
        MyThread4 thread4 = new MyThread4(hostName);
        thread4.start();
	}

}

class MyThread4 extends Thread {
	String hostname;

	public MyThread4(String hostname) {
		super();
		this.hostname = hostname;
	}

	@Override
	public void run() {
		try {
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress nullHost = InetAddress.getByName(null);
            InetAddress siteHost = InetAddress.getByName(hostname);
            
            System.out.println("Local Host Address: " + localHost.getHostAddress());
            System.out.println("Null Host Address: " + nullHost.getHostAddress());
            System.out.println("Site Host Address: " + siteHost.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error retrieving host address: " + e.getMessage());
        }
	}
}