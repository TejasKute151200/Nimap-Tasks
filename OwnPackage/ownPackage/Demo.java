package corejava.ownPackage;
import corejava.packages.HelloWorld;

public class Demo
{
	public static void main(String []args)
	{	
		//create object
		HelloWorld helloworld = new HelloWorld();
		System.out.println("Print Message By Using Other Package >>> "+ helloworld.a());
	}
}
