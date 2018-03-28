
public class SalariedEmployee extends Employee{

	private double annualSalary = 0;
	
	/**
	 * Creates a new Salaried employee
	 * @param id The id
	 * @param name The name
	 * @param rate The rate of pay
	 */
	public SalariedEmployee(String id, String name) {
		super(name, id);
	}

	/**
	 * Sets the annual salary of the employee
	 * @param salary
	 */
	public void setAnnualSalary(double salary) {
		this.annualSalary = salary;
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
		return "Employee Name: " + getEmployeeName() + ", Employee Id: " + getEmployeeId() +", Employee Annual Salary: " + this.annualSalary + ", Weekly Employee Pay: " + paycheck();
	}

	
	
}
