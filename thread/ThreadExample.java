package corejava.thread;

public class ThreadExample {
	public static void main(String[] args)  {
		System.out.println("<<<<>>>> START <<<<>>>>");
		
		int a= 26+24;
		System.out.println(" Sum of Numbers are "+a);
		
		//Thread..
		Thread t= Thread.currentThread();
		String tname=t.getName();
		System.out.println(" Our Thread Name is "+tname);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		t.setName("TejasThread");
		System.out.println(" New Name Of Our Thread is "+t.getName());
		System.out.println(" Thread ID is "+ t.getId());
		
		System.out.println("<<<<>>>> ENDED <<<<>>>>");
	}

}