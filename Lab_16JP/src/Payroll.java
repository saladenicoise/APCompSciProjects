import java.io.*;
import java.util.*;

public class Payroll {

	/**
	 * The list containing all the employee payrolls and such
	 */
	private static LinkedList<Employee> payroll = new LinkedList<Employee>();

	/**
	 * Main menu function
	 * @param args
	 * @throws notValidEmployeeTypeException not a valid employee type
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws notValidEmployeeTypeException, notValidMenuOptionException {
		Scanner menuChoice = new Scanner(System.in);
		int choice = 0;
		while(choice != 7) {
			System.out.println();
			System.out.println("Welcome to payroll system v 1.0");
			System.out.println("-------------------------------");
			System.out.println("1. Display Payroll Information");
			System.out.println("2. Add an Employee");
			System.out.println("3. Remove an Employee");
			System.out.println("4. Update hourly worker pay");
			System.out.println("5. Calculate total payroll");
			System.out.println("6. Access Employee Record");
			System.out.println("7. Quit");
			System.out.println("-------------------------------");
			System.out.print("Choice: ");
			try {
			choice = menuChoice.nextInt();
			}catch(InputMismatchException e) {
				notValidMenuOptionException error = new notValidMenuOptionException("Incorrect Menu Option. Please relaunch");
				error.printStackTrace();
			}
			choice = 0;
			if(choice == 1) {
				displayPayrollInfo();
			}else if(choice == 2) {
				Scanner employeeType = new Scanner(System.in);
				System.out.println("Which kind of employee would you like to add(hourly/salaried): ");
				String employeeTyp = employeeType.nextLine();
				addEmployee(employeeTyp);
			}else if(choice == 3) {
				deleteEmployee();
			}else if(choice == 4) {
				updateEmployeeHours();
			}else if(choice == 5) {
				calculateTotalPayroll();
			}else if(choice == 6) {
				System.out.println("Enter employee Id: ");
				Scanner id = new Scanner(System.in);
				String idVar = id.nextLine();
				accessEmployeeRecord(idVar);
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
			HourlyEmployee employee = new HourlyEmployee(name, id, employeeType);
			System.out.println("How many hours as employee \"" + name + "\" worked? ");
			double hoursWorked = input.nextDouble();
			employee.setWorkHours(hoursWorked);
			employee.setHourlyPay(currPay);
			payroll.add(employee);
		}else if(employeeType.equals("salaried")) {
			System.out.println("Name of employee: ");
			String name = userInput.nextLine();
			System.out.println("Employee ID: ");
			String id = userInput.nextLine();
			SalariedEmployee employee = new SalariedEmployee(name, id, employeeType);
			System.out.println("Current Annual Salary: ");
			double currSalary = input.nextDouble();
			employee.setAnnualSalary(currSalary);
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
		for(int a = 0; a < payroll.size(); a++) {
			Employee currEmployee = payroll.get(a);
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
				HourlyEmployee employee = new HourlyEmployee(name, id, "hourly");
				employee.setWorkHours(workHours);
				payroll.set(counter, employee);
			}
		}
	}

	/**
	 * Display Payroll
	 */
	public static void displayPayrollInfo() {
		ArrayList<Employee> hourlySort = new ArrayList<Employee>();
		ArrayList<Employee> salariedSort = new ArrayList<Employee>();
		for(Employee e : payroll) {
			if(e.getEmployeeType().equals("hourly")) {
				hourlySort.add(e);
			}else if(e.getEmployeeType().equals("salaried")) {
				salariedSort.add(e);
			}
			Collections.sort(hourlySort, new PayrollComparator());
			Collections.sort(salariedSort, new PayrollComparator());
		}
		payroll.clear();
		payroll.addAll(hourlySort);
		payroll.addAll(salariedSort);
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
	 * @return total paycheck
	 */
	public static void calculateTotalPayroll() {
		double total = 0;
		for(Employee e : payroll) {
			total += e.paycheck();
		}
		System.out.println("Total Weekly pay for the company is: " + total + "$");
	}
	
	public static void accessEmployeeRecord(String id) {
		for(Employee e : payroll) {
			if(e.getEmployeeId().equals(id)) {
				e.toString();
			}
		}
	}
}
