package threadGroup;

public class MyThread extends Thread {

	public MyThread(ThreadGroup group, String name, int priority) {
		super(group, name);
		this.setPriority(priority);
	}

	@Override
	public void run() {
		super.run();
		System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
        System.out.println("Thread State: " + getState());
        System.out.println("Is child of thread: " + getThreadGroup().getName() + "\n");
	}
	
}
