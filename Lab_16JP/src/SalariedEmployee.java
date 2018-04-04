
public class SalariedEmployee extends Employee{

	private double annualSalary = 0;
	
	
	/**
	 * Creates a new Salaried employee
	 * @param id The id
	 * @param name The name
	 * @param rate The rate of pay
	 */
	public SalariedEmployee(String id, String name, String empType) {
		super(name, id, empType);
	}

	/**
	 * Sets the annual salary of the employee
	 * @param salary
	 */
	public void setAnnualSalary(double salary) {
		this.annualSalary = salary;
	}
	
	/**
	 * Give a raise
	 * @param raise to add
	 */
	@Override
	public void giveRaise(double raise) {
		this.annualSalary += raise;
	}
	
	/**
	 * Calculates the paycheck for the employee
	 */
	@Override
	public double paycheck() {
		return (annualSalary/52);
	}
	
	/**
	 * Overitten toString.
	 */
	@Override
	public String toString() {
		return "Employee Type: " + getEmployeeType() + ", Employee Name: " + getEmployeeName() + ", Employee Id: " + getEmployeeId() +", Employee Annual Salary: " + this.annualSalary + ", Weekly Employee Pay: " + paycheck();
	}

	
	
}
