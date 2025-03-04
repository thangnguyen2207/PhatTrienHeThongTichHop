package chapter2;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Section1v1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhap chuoi URL:");
		String url = scan.nextLine();
		scan.close();
		
		MyThread1 thread1 = new MyThread1(url);
		thread1.start();

	}
}

class MyThread1 extends Thread {
	String url;
	
	public MyThread1(String url) {
		super();
		this.url = url;
	}

	@Override
	public void run() {
		try {
			URI uri = new URI(url);
			URL url = uri.toURL();
			System.out.println("-----------------");
			System.out.println("Thong tin tu URL:");
			System.out.println("Host: " + uri.getHost());
			System.out.println("Path: " + uri.getPath());
			System.out.println("Port: " + uri.getPort());
			System.out.println("Protocol: " + url.getProtocol());
			
		} catch (URISyntaxException e) {
			System.err.println("Khong the thu thap du lieu tu URL da nhap");
		} catch (MalformedURLException m) {
			System.err.println("Khong the thu thap du lieu tu URL da nhap");
		}
	}
}
