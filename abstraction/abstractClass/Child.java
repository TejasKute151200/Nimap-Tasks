package corejava.abstraction.abstractClass;

public class Child extends Parent
{
	@Override
	public String occupationDetail() 
	{
		return "Employee";
	}
	public static void main(String []args)
	{
		Parent p = new Child();
		System.out.println(" Defining Method CALL >>> "+p.occupationInfo());
		System.out.println(" Declaring Method CALL >>> "+p.occupationDetail());
	}
}
