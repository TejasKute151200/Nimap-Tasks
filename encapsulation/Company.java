package corejava.encapsulation;

public class Company {
	private long employeeId;
	private String employeeName;
	private int experianceInYears;
	private String qualification;
	private String location;
	private String mobileNumber;

	public long getEmployeeId() 
	{
		return employeeId;
	}
	public void setEmployeeId(long employeeId) 
	{
		this.employeeId = employeeId;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}

	public int getExperianceInYears() 
	{
		return experianceInYears;
	}
	public void setExperianceInYears(int experianceInYears) 
	{
		this.experianceInYears = experianceInYears;
	}

	public String getQualification() 
	{
		return qualification;
	}
	public void setQualification(String qualification)
	{
		this.qualification = qualification;
	}

	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getMobileNumber() 
	{
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}

	public static void main(String[] args)
	{
		Company employeeDetails = new Company();
		employeeDetails.setEmployeeId(1919);
		employeeDetails.setEmployeeName("Tejas Kute");
		employeeDetails.setExperianceInYears(2);
		employeeDetails.setQualification("Bacherlor Of Science in Information Technology");
		employeeDetails.setLocation("Mumbai");
		employeeDetails.setMobileNumber("7738225083");

		System.out.println(" ------------ Employee Details ------------ ");
		System.out.println("  Id >>> " + employeeDetails.employeeId);
		System.out.println("  Name >>> " + employeeDetails.employeeName);
		System.out.println("  Experiance(in years) >>> " + employeeDetails.experianceInYears);
		System.out.println("  Qualification >>> " + employeeDetails.qualification);
		System.out.println("  Location >>> " + employeeDetails.location);
		System.out.println("  Mobile Number >>> " + employeeDetails.mobileNumber);
		System.out.println(" ------------------------------------------- ");
	}
}
