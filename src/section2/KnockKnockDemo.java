package section2;

public class KnockKnockDemo {

	public static void main(String[] args) {
		KnockKnockServer server = new KnockKnockServer();

		synchronized (server) {
			server.start();
			try {
				server.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		KnockKnockClient client = new KnockKnockClient();
		client.start();
	}

}
