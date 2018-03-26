import java.io.*;
import java.util.*;

public class Payroll {

	private static ArrayList<Employee> payroll = new ArrayList<Employee>();

	public static void main(String[] args) throws notValidEmployeeTypeException {
		addEmployee("hourly");
		//for(Employee e : payroll) {
		//	System.out.println(e.toString());
		//}
		deleteEmployee("hourly");
		if(payroll.size() > 0) {
			for(Employee e : payroll) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("Empty Thingy");
		}
	}

	public static void addEmployee(String employeeType) throws notValidEmployeeTypeException{
		employeeType.toLowerCase();
		Scanner userInput = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		if(employeeType.equals("hourly")) {
			System.out.println("Name of employee: ");
			String name = userInput.nextLine();
			System.out.println("Employee ID: ");
			String id = userInput.nextLine();
			System.out.println("Current Pay: ");
			double currPay = input.nextDouble();
			HourlyEmployee employee = new HourlyEmployee(name, id, currPay);
			System.out.println("How many hours as employee \"" + name + "\" worked? ");
			double hoursWorked = input.nextDouble();
			employee.setWorkHours(hoursWorked);
			payroll.add(employee);
		}else if(employeeType.equals("salaried")) {
			System.out.println("Name of employee: ");
			String name = userInput.nextLine();
			System.out.println("Employee ID: ");
			String id = userInput.nextLine();
			System.out.println("Current Rate of Pay: ");
			double currRate = input.nextDouble();
			SalariedEmployee employee = new SalariedEmployee(name, id, currRate);
			payroll.add(employee);
		}else {
			throw new notValidEmployeeTypeException("Incorect Employee Type");
		}
	}

	public static void deleteEmployee(String employeeType) throws notValidEmployeeTypeException {
		Scanner userInput = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		if(employeeType.equals("hourly")) {
			System.out.println("Employee Id: ");
			String id = userInput.nextLine();
			for(Iterator<Employee> e) {
				if(e.getEmployeeId().equals(id)) {
					payroll.remove(e);
				}
			}
		}else if(employeeType.equals("salaried")) {
			System.out.println("Name of employee: ");
			String name = userInput.nextLine();
			System.out.println("Employee ID: ");
			String id = userInput.nextLine();
			System.out.println("Current Rate of Pay: ");
			double currRate = input.nextDouble();
			SalariedEmployee employee = new SalariedEmployee(name, id, currRate);
			payroll.remove(employee);
		}else {
			throw new notValidEmployeeTypeException("Incorect Employee Type");
		}
	}

}
