package corejava.memoryAllocation;

public class MemoryAllocation 
{
	public static void main(String[] args) 
	{
		MethodClass tejas1 = new MethodClass();
		MethodClass tejas2 = tejas1;
		tejas1.setText("Hello, I am Tejas");
		System.out.println(tejas2.text);
	}
}
