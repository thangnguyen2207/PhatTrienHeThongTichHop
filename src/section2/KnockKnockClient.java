package section2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class KnockKnockClient extends Thread {
	private String host;
	private int port;
	
	public KnockKnockClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public KnockKnockClient() {
		this.host = "localhost";
		this.port = 12345;
	}


	@Override
	public void run() {
		super.run();
		
		try (Socket socket = new Socket(host, port);
	             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	             Scanner scanner = new Scanner(System.in)) {
	            
	            String serverMessage;
	            
	            //Vòng lặp while chạy mãi nếu serverMessage khác null
	            //Nếu serverMessage trả về "Bye!" sẽ kết thúc chương trình
	            //Nếu serverMessage trả về "You're supposed to say...", in ra dòng tiếp theo server sẽ gửi đến (Knock knock)
	            //Ngoài ra client sẽ cho user nhập String vào để tiếp tục hội thoại
	            while ((serverMessage = in.readLine()) != null) {
	                System.out.println("Server: " + serverMessage);
	                if (serverMessage.equals("Bye!")) break;
	                if (serverMessage.contains("You're supposed to say"))
	                	System.out.println(in.readLine());
	                
	                String userInput = scanner.nextLine();
	                out.println(userInput);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}