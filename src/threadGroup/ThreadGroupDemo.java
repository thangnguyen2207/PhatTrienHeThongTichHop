package threadGroup;

public class ThreadGroupDemo {

	public static void main(String[] args) {
        // Tạo ThreadGroup 1
        ThreadGroup group1 = new ThreadGroup("Group 1");
        group1.setMaxPriority(5); // Đặt giới hạn độ ưu tiên tối đa cho nhóm

        // Tạo Thread 1 và Thread 2 thuộc Group 1
        Thread thread1 = new Thread(group1, "Thread 1") {
            @Override
			public void run() {
            	try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        thread1.setPriority(3);

        Thread thread2 = new Thread(group1, "Thread 2") {
            @Override
			public void run() {
            	try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        thread2.setPriority(5);

        // Tạo ThreadGroup 2
        ThreadGroup group2 = new ThreadGroup("Group 2");

        // Tạo Thread 3 và Thread 4 thuộc Group 2
        Thread thread3 = new Thread(group2, "Thread 3") {
            @Override
			public void run() {
            	try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        thread3.setPriority(6);

        Thread thread4 = new Thread(group2, "Thread 4") {
            @Override
			public void run() {
            	try {
					sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        thread4.setPriority(4);

        // Start threads (để chạy nền)
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // In thông tin của ThreadGroup và Threads
        printThreadGroupInfo(group1);
        System.out.println("");
        printThreadGroupInfo(group2);
    }

    private static void printThreadGroupInfo(ThreadGroup group) {
        System.out.println("Thread Group Name: " + group.getName());
        System.out.println("Parent Thread Group: " + (group.getParent() != null ? group.getParent().getName() : "None"));
        System.out.println("Max Priority: " + group.getMaxPriority());
        System.out.println("Active Thread Count: " + group.activeCount());
        System.out.println("Active Group Count: " + group.activeGroupCount());
        System.out.println("List of active thread:");

        // Lấy danh sách các thread trong nhóm
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread t : threads) {
            if (t != null) {
                System.out.println("    Thread Name: " + t.getName());
                System.out.println("    Thread Priority: " + t.getPriority());
                System.out.println("    Thread State: " + t.getState());
                System.out.println("    --------------");
            }
        }
    }

}
