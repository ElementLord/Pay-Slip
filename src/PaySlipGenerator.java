import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaySlipGenerator {

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();
		String userInput = "";
		
		System.out.print("Enter Employee Details: ");
		userInput = input.nextLine();
		
		while (!userInput.equals("")) 
		{
			String[] splitString = userInput.split(",");
			employees.add(new Employee(splitString[0], splitString[1], Integer.parseInt(splitString[2]), splitString[4], splitString[3]));
			System.out.print("Enter Next Employee Details: ");
			userInput = input.nextLine();
		}
		
		System.out.println();
		System.out.println("Employee(s) Pay Slip:");
		
		for (int i = 0; i < employees.size(); i++) 
		{
			System.out.println(employees.get(i).Print());
		}
		
		//For debugging
		//Employee employee;
		//String employeeInput2 = "Monica,Tan,60050,9%,01 March – 31 March";
		//String employeeInput = "Brend,Tulu,120000,10%,01 March – 31 March";
		//String employeeInput = "Monica,Tan,60050,9%,01 March – 31 March";
		//String employeeInput = "Brend,Tulu,120000,10%,01 March – 31 March";
		//String[] splitString = employeeInput.split(",");
		//employee = new Employee(splitString[0], splitString[1], Integer.parseInt(splitString[2]), splitString[4], splitString[3]);
		//System.out.print(employee.Print());
	}
}
