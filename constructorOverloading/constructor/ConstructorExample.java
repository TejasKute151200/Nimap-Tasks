package corejava.constructor;

public class ConstructorExample
{   
	public ConstructorExample() //Default
	{
		System.out.println("Tejas");
	}
	
	int a;
	public ConstructorExample(int b) //Parameterized Constructor
	{
		this.a=b;
	}
	
	int i;
	String j;
	public ConstructorExample(int e, String f) //Parameterized Constructor
	{
		this.i= e;
		this.j= f;
	}
	
	public static void main(String[] args)
	{

		ConstructorExample d= new ConstructorExample();//Object Create by Using Default Constructor
		
		ConstructorExample c= new ConstructorExample(21);//Object Create by Using 1 Parameter Constructor
		System.out.println(c.a);
		
		ConstructorExample g = new ConstructorExample(2000,"Mumbai");//Object Create by Using Multiple Parameter Constructor
		System.out.println(g.i+" "+g.j);
	}

}
