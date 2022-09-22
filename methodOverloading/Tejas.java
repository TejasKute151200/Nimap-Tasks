package corejava.methodOverloading;

public class Tejas
{
public int abc(int a, int b) 
{
	return a+b;
}
public int abc(int a)
{
	return a;	
}
	
	public static void main(String[] args)
	{
		Tejas t= new Tejas();
		
		System.out.println(" Normal Method >>> " + t.abc(34,21));
		System.out.println(" Overloaded Method >>> " + t.abc(10));
		
	}

}
