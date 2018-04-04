
public class HourlyEmployee extends Employee{

	/*
	 * Name: Jules Petit
	 * Block: E
	 */
	/**
	 * How many hours the employee has worked. 
	 */
	private double workHours = 0;
	/**
	 * The employee's current pay
	 */
	private double hourlyPay = 0;
	/**
	 * Creates a new a hourly employee
	 * @param name Name of employee
	 * @param id their id
	 * @param pay how much they make per hour
	 */
	public HourlyEmployee(String name, String id, String empType) {
		super(id, name, empType);
	}

	/**
	 * Assigns a set number of work hours to the current employee
	 * @param work
	 */
	public void setWorkHours(double work) {
		this.workHours = work;
	}
	
	/**
	 * Set how many hours they work.
	 * @param pay
	 */
	public void setHourlyPay(double pay) {
		this.hourlyPay = pay;
	}
	
	/**
	 * Gets the hourly pay of the employee
	 * @return hourly
	 */
	public double getPay() {
		return this.hourlyPay;
	}
	
	/**
	 * Function to give the raise
	 * @param 
	 */
	@Override
	public void giveRaise(double raise) {
		this.hourlyPay += raise;
	}

	/**
	 * Function to calculate the paycheck of hourly employees
	 */
	@Override
	public double paycheck() {
		if(workHours <= 40) {
			return workHours * getPay(); 
		}else {
			return (workHours * getPay()) + ((workHours-40)*(1.5*getPay()));
		}
	}
	
	/**
	 * Overritten to string.
	 */
	@Override
	public String toString() {
		return "Employee Type: " + getEmployeeType() + ", Employee Name: " + getEmployeeName() + ", Employee Id: " + getEmployeeId() + ", Employee Hours: " + workHours + ", Hourly Pay: " + getPay() + ", Pay check: " + paycheck();
	}

}
