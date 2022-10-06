package corejava.thread;

//Create Thread With The Help of Runnable Interface
public class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i<=10;i++) {
			System.out.println("The Value of i is "+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		
		MyThread t = new MyThread(); // Create Object Of MyThread Class
		Thread t2= new Thread(t);	// Create Object With The Help of Pre-defined Thread Class From java.lang Package & Stored MyThread Class Object 
		t2.start();
		MySecondThread s1= new MySecondThread();
		s1.start();
	}

}
