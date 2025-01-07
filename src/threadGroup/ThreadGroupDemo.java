package threadGroup;

public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {
        // Tạo ThreadGroup
        ThreadGroup group1 = new ThreadGroup("Group 1");
        ThreadGroup group2 = new ThreadGroup("Group 2");

        // Tạo Thread 1 và Thread 2 thuộc Group 1
        MyThread thread1 = new MyThread(group1, "Thread 1", 3);
        MyThread thread2 = new MyThread(group1, "Thread 2", 5);
        MyThread thread3 = new MyThread(group2, "Thread 3", 6);
        MyThread thread4 = new MyThread(group2, "Thread 4", 4);

        // Start threads (để chạy nền)
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();

        // In thông tin của ThreadGroup và Threads
        printThreadGroupInfo(group1);
        System.out.println("");
        printThreadGroupInfo(group2);
    }

    private static void printThreadGroupInfo(ThreadGroup group) {
        System.out.println("Thread Group Name: " + group.getName());
        System.out.println("Parent Thread Group: " + (group.getParent() != null ? group.getParent().getName() : "None"));
        System.out.println("Max Priority: " + group.getMaxPriority());
    }

}
