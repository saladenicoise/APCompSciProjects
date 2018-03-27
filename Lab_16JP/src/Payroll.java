import java.awt.Choice;
import java.io.*;
import java.util.*;

public class Payroll {

	private static LinkedList<Employee> payroll = new LinkedList<Employee>();

	/**
	 * Main menu function
	 * @param args
	 * @throws notValidEmployeeTypeException not a valid employee type
	 */
	public static void main(String[] args) throws notValidEmployeeTypeException {
		Scanner menuChoice = new Scanner(System.in);
		int choice = 0;
		while(choice != 6) {
			System.out.println();
			System.out.println("Welcome to payroll system v 1.0");
			System.out.println("-------------------------------");
			System.out.println("1. Display Payroll Information");
			System.out.println("2. Add an Employee");
			System.out.println("3. Remove an Employee");
			System.out.println("4. Update hourly worker pay");
			System.out.println("5. Calculate total payroll");
			System.out.println("6. Quit");
			System.out.println("-------------------------------");
			System.out.print("Choice: ");
			choice = menuChoice.nextInt();
			switch(choice) {
			case 1:
				displayPayrollInfo();
				break;
			case 2:
				Scanner employeeType = new Scanner(System.in);
				System.out.println("Which kind of employee would you like to add(hourly/salaried): ");
				String employeeTyp = employeeType.nextLine();
				addEmployee(employeeTyp);
				break;
			case 3:
				deleteEmployee();
				break;
			case 4:
				updateEmployeeHours();
				break;
			case 5:
				calculateTotalPayroll();
				break;
			default :
				break;
			}
		}
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	/**
	 * Adds an employee
	 * @param employeeType hourly or salaried
	 * @throws notValidEmployeeTypeException not a valid employee type
	 */

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

	
	/**
	 * Deletes an employee given the id
	 */
	public static void deleteEmployee(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Employee Id: ");
		String id = userInput.nextLine();
		for(Iterator<Employee> e = payroll.iterator(); e.hasNext();) {
			Employee currEmployee = e.next();
			if(currEmployee.getEmployeeId().equals(id)) {
				payroll.remove(currEmployee);
			}
		}
	}

	/**
	 * Update hourly employee hours
	 */
	public static void updateEmployeeHours() {
		Scanner userInput = new Scanner(System.in);
		Scanner userInput2 = new Scanner(System.in);
		int counter = 0;
		System.out.println("Employee Id: ");
		String id = userInput.nextLine();
		for(Iterator<Employee> e = payroll.iterator(); e.hasNext();) {
			Employee currEmployee = e.next();
			counter++;
			if(currEmployee.getEmployeeId().equals(id)) {
				String name = currEmployee.getEmployeeName();
				System.out.println("How many hours has employee \"" + name + "\" worked: ");
				double workHours = userInput2.nextDouble();
				HourlyEmployee employee = new HourlyEmployee(name, id, currEmployee.getPay());
				employee.setWorkHours(workHours);
				payroll.set(counter, employee);
			}
		}
	}

	/**
	 * Display Payroll
	 */
	public static void displayPayrollInfo() {
		if(payroll.size() > 0) {
			for(Employee e : payroll) {
				System.out.println(e.toString());
			}
		}else {
			System.out.println("No employees present");
		}
	}

	/**
	 * Calc total payroll
	 * @return total
	 */
	public static double calculateTotalPayroll() {
		double total = 0;
		for(Employee e : payroll) {
			total += e.paycheck();
		}
		return total;
	}
}
