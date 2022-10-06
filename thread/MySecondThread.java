package corejava.thread;

// Create Thread With The Help of Pre-Defined Thread Class
public class MySecondThread extends Thread {

	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			System.out.println("The Value of Second i is... " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
