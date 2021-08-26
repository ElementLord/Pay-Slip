public class Employee {
	//User Entered
	private String firstName;
	private String lastName;
	private int annualSalary;
	private double superRate;
	private String fromDate;
	private String toDate;
	
	//Preset
	private int paymentPeriod = 1; 
	
	//Calculated
	private int grossIncome;
	private int incomeTax;
	private int superannuation;
	private int netIncome;
	
	public Employee(String fName, String lName, String aSalary, String sRate, String pPeriod) 
	{
		firstName = fName;
		lastName = lName;
		annualSalary = Integer.parseInt(aSalary);
		superRate = Double.parseDouble(sRate.replace("%", "")) / 100; 
		
		String[] splitDate = pPeriod.replace('–', '-').split(" - ");
		fromDate = splitDate[0];
		toDate = splitDate[1];
		grossIncome = (int) Math.round(annualSalary / 12.0 * paymentPeriod);
		
		if (annualSalary >= 180001) 
		{
			incomeTax = (int) Math.round((54232 + ((annualSalary - 180000) * 0.45)) / 12 * paymentPeriod); 
		}
		else if (annualSalary >= 87001) 
		{
			incomeTax = (int) Math.round((19822 + ((annualSalary - 87000) * 0.37)) / 12 * paymentPeriod);
		}
		else if (annualSalary >= 37001) 
		{
			incomeTax = (int) Math.round((3572 + ((annualSalary - 37000) * 0.325)) / 12 * paymentPeriod);
		}
		else if (annualSalary >= 18201) 
		{
			incomeTax = (int) Math.round(((annualSalary - 18200) * 0.325) / 12 * paymentPeriod);
		}
		else 
		{
			incomeTax = 0;
		}
		
		netIncome = (int) Math.round(grossIncome - incomeTax); 
		superannuation = (int) Math.round(grossIncome * superRate);
	}
	
	public String PrintPaySlip() 
	{
		return firstName + " " + lastName + "," + fromDate + " - " + toDate + "," + grossIncome + "," + incomeTax + "," + netIncome + "," + superannuation;
	}
}
