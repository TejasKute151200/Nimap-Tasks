package corejava.abstraction.interfaces;

public class Child implements Parent
{
	@Override
	public String occupationDetail() 
	{	
		return "Business";
	}
	
	public static void main(String[] args)
	{
		Parent parentOccupation= new Child();	
		System.out.println(" Parent Occupation >>> "+ parentOccupation.occupationDetail());
	}
}
