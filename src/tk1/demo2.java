package tk1;
import java.io.*;

class FileHandler {
    private final File file = new File("input.txt");
    
    public synchronized void writeNumbers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            StringBuilder numbersWritten = new StringBuilder();
            for (int n = 1; n <= 10; n++) {
                int number = (int) Math.pow(2, n);
                writer.write(number + " ");
                numbersWritten.append(number).append(" ");
            }
            writer.newLine();
            System.out.println("Thread 1: Đã ghi số vào file: " + numbersWritten.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void readAndSumNumbers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numbers = line.trim().split(" ");
                int sum = 0;
                for (String num : numbers) {
                    sum += Integer.parseInt(num);
                }
                System.out.println("Thread 2: Tổng in ra: " + sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriterThread extends Thread {
    private final FileHandler fileHandler;

    public WriterThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        setPriority(5);
    }

    @Override
    public void run() {
        fileHandler.writeNumbers();
    }
}

class ReaderThread extends Thread {
    private final FileHandler fileHandler;

    public ReaderThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        setPriority(5);
    }

    @Override
    public void run() {
        fileHandler.readAndSumNumbers();
    }
}

public class demo2 {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        WriterThread writerThread = new WriterThread(fileHandler);
        ReaderThread readerThread = new ReaderThread(fileHandler);

        writerThread.start();
        readerThread.start();
    }
}