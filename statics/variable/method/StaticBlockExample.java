package corejava.statics.variable.method;

public class StaticBlockExample 
{
	static //static block
	{
		System.out.println("static run ..."); //static block run before main method
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World !..");

	}

}
