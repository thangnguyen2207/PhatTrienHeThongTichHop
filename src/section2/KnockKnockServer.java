package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class KnockKnockServer extends Thread {
	private int port;

	public KnockKnockServer(int port) {
		this.port = port;
	}

	public KnockKnockServer() {
		this.port = 12345;
	}


	@Override
	public void run() {
			try (ServerSocket serverSocket = new ServerSocket(port)) {
	            System.out.println("Server started. Waiting for clients...");

	            synchronized (this) {
					this.notify();
				}

	            while (true) {
	            	Socket clientSocket = serverSocket.accept();
	                System.out.println("Client connected.");

	                InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
	                BufferedReader in = new BufferedReader(reader);
	                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

	                while (true) {
	                	out.println("Knock! Knock!");

	                    String response = in.readLine();
	                    if (!response.equalsIgnoreCase("Who's there?")) {
	                        out.println("You're supposed to say 'Who's there?'! Try again.");
	                        continue;
	                    }

	                    out.println("Turnip");

	                    response = in.readLine();
	                    if (!response.equalsIgnoreCase("Turnip who?")) {
	                        out.println("You're supposed to say 'Turnip who?'! Try again.");
	                        continue;
	                    }

	                    out.println("Turnip the heat, it's cold in here! Want another? (y/n)");
	                    response = in.readLine();
	                    if (response == null || !response.equalsIgnoreCase("y")) {
	                        out.println("Bye!");
	                        break;
	                    }

	                }

	            }
	        } catch (IOException e) {
	            System.err.println(e.getMessage());
	        }
	}

}