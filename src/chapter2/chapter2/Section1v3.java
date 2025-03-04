package chapter2;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Section1v3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhap chuoi URL:");
		String url = scan.nextLine();
		scan.close();
		
		MyThread3 thread3 = new MyThread3(url);
		thread3.start();

	}

}

class MyThread3 extends Thread {
	String url;

	public MyThread3(String url) {
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

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Map<String, List<String>> headers = connection.getHeaderFields();
				for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
					if (entry.getKey() != null) {
						System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
					}
		        }
			}
		} catch (Exception e) {
			System.err.println("Co loi xay ra");
		}
	}
}