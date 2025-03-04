package chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Section1v2 {
	
	public static void main(String[] args) {
		String url = "https://www.facebook.com/";
		MyThread2 thread2 = new MyThread2(url);
		thread2.start();
	}
}

class MyThread2 extends Thread {
	String url;
	
	public MyThread2(String url) {
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
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				String outputLine;
				while ((outputLine = reader.readLine()) != null) {
					System.out.println(outputLine);
				}
				reader.close();
				
			}
		} catch (Exception e) {
			System.err.println("Co loi xay ra");
		}
	}
}
