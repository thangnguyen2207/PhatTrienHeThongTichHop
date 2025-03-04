package chapter2;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Section1v5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhap chuoi URL:");
		String url = scan.nextLine();
		scan.close();
		
		MyThread5 thread5 = new MyThread5(url);
		thread5.start();
	}

}

class MyThread5 extends Thread {
	String url;

	public MyThread5(String url) {
		super();
		this.url = url;
	}

	@Override
	public void run() {
        try {
        	URI uri = new URI(url);
			URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            System.out.println("Content Type: " + connection.getContentType());
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Last Modified: " + connection.getLastModified());
            System.out.println("Expiration: " + connection.getExpiration());
            
        } catch (Exception e) {
            System.out.println("Error fetching document properties: " + e.getMessage());
        }
	}
}
