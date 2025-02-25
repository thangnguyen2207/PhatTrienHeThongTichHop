package tk1;
import java.util.regex.*;

class NumberThread extends Thread {
    private String input;

    public NumberThread(String input) {
        this.input = input;
        setPriority(5);
    }

    @Override
    public void run() {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(input);
        System.out.println("Thread 1: Chuỗi con có 4 ký số liên tiếp:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

class CharacterThread extends Thread {
    private String input;

    public CharacterThread(String input) {
        this.input = input;
        setPriority(5);
    }

    @Override
    public void run() {
        Pattern pattern = Pattern.compile(".{6}");
        Matcher matcher = pattern.matcher(input);
        System.out.println("Thread 2: Chuỗi con có 6 ký tự liên tiếp:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

public class demo {
    public static void main(String[] args) {
        String input = "abc1234xyz5678@#$%^helloWorld1";

        NumberThread thread1 = new NumberThread(input);
        CharacterThread thread2 = new CharacterThread(input);

        thread1.start();
        try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        thread2.start();
    }
}