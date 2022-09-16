package corejava.premitiveReference;

import java.awt.Point;

public class PremitiveReference
{
	public static void main(String[] args)
	{
	//premitive 
	//byte,short,int,long,float,double,char,boolean
	int a= 4;
	int b= a;
	a=6;
	System.out.println("Premitive >>> "+ b);
	
	//reference
	//String,Class,Interface,etc.
	Point c= new Point(3,4);
	Point d= c;
	d.x= 4;
	System.out.println("Reference >>> "+ d);
	}
}
