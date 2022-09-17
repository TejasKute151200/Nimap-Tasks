package corejava.abstraction;

public class Tejas extends Father implements Mother
{
	@Override
	public String serviceDetail()
	{
		return "House Wife";
	}

	@Override
	public String jobInfo()
	{
		return "Government Sector";
	}

	public static void main(String[] args)
	{
		Mother mother = new Tejas();
		Father father = new Tejas();
		
		System.out.println(" ---------- Parents Occupation Details ---------- ");
		System.out.println("  Mother Occupation >>> "+mother.serviceDetail());
		System.out.println("  Father Occupation Sector >>> "+father.jobInfo());
		System.out.println("  Father Occupation Datail >>> "+father.jobDetail());
		System.out.println(" ------------------------------------------------ ");
	}
}
