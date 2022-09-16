package corejava.typeCasting;

public class TypeCasting
{
	public static void main(String[]args)
	{
	byte a=4; 
	short b= a; //automatic casting
	int c= b;
	System.out.println("Automatic Type Casting >>> "+c);
	
	double d =9;
	int e= (int) d; //conversion casting
	System.out.println("Conversion Casting >>> "+ e);
	}	
}
