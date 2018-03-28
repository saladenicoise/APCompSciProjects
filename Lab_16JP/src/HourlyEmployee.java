
public class HourlyEmployee extends Employee{

	private double workHours = 0;
	private double hourlyPay = 0;
	/**
	 * Creates a new a hourly employee
	 * @param name Name of employee
	 * @param id their id
	 * @param pay how much they make per hour
	 */
	public HourlyEmployee(String name, String id) {
		super(id, name);
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
	 * @return
	 */
	public double getPay() {
		return this.hourlyPay;
	}

	/**
	 * Function to calculate the paycheck of hourly employees
	 */
	@Override
	public double paycheck() {
		if(workHours <= 40) {
			return workHours * getPay(); 
		}else {
			workHours -= 40;
			return workHours * (1.5 * getPay());
		}
	}
	
	/**
	 * Overritten to string.
	 */
	@Override
	public String toString() {
		return "Employee Name: " + getEmployeeName() + ", Employee Id: " + getEmployeeId() + ", Hourly Pay: " + getPay() + ", Pay check: " + paycheck();
	}

}
