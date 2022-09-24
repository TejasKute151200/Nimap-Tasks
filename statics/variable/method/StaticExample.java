package corejava.statics.variable.method;

public class StaticExample
{
int age;
String firstName;
static String lastName = "Kute";

//	static void change() 			//Create Static Method
//	{
//		lastName=" KUTE";
//	}

StaticExample(int a,String b) //Constructor
{
	this.age=a;
	this.firstName=b;
}
void display()
{
	System.out.println(age+ firstName+ lastName);
}
	public static void main(String[] args)
	{
		//StaticVariableExample.change(); // Calling Static Method
		StaticExample se1=new StaticExample(21," Tejas ");
		StaticExample se2=new StaticExample(26," Ranjit ");
		StaticExample se3=new StaticExample(45," Savitra ");
		StaticExample se4=new StaticExample(52," Sanjay ");
		
		se1.display();
		se2.display();
		se3.display();
		se4.display();
	}

}
