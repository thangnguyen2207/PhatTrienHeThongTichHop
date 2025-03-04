package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class KnockKnockServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String[] jokes = {"Turnip the heat, it's cold in here!", "Lettuce in, it's freezing out here!"};
            int jokeIndex = 0;
            
            while (true) {
                out.println("Knock! Knock!");
                if (!in.readLine().equalsIgnoreCase("Who's there?")) {
                    out.println("You're supposed to say 'Who's there?'! Try again.");
                    continue;
                }
                
                String jokePrompt = jokes[jokeIndex].split(" ")[0];
                out.println(jokePrompt);
                if (!in.readLine().equalsIgnoreCase(jokePrompt + " who?")) {
                    out.println("You're supposed to say '" + jokePrompt + " who?'! Try again.");
                    continue;
                }
                
                out.println(jokes[jokeIndex] + " Want another? (y/n)");
                if (!in.readLine().equalsIgnoreCase("y")) {
                    out.println("Bye!");
                    break;
                }
                
                jokeIndex = (jokeIndex + 1) % jokes.length;
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}