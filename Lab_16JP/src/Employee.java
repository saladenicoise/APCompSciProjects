public abstract class Employee {

	private String employeeId = "";
	private String employeeName = "";
	private double hourlyRate = 0;
	
	/**
	 * Creates a new employee
	 * @param id Employee Id
	 * @param name Employee Name
	 * @param rate Employee's pay
	 */
	public Employee(String id, String name, double rate) {
		this.employeeId = id;
		this.employeeName = name;
		this.hourlyRate = rate;
	}
	
	/**
	 * Changes employee name
	 * @param newName new name for the employee
	 */
	public void changeEmployeeName(String newName) {
		this.employeeName = newName;
	}
	
	/**
	 * Gets employee name
	 * @return employee name
	 */
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	/**
	 * Gets the employee id.
	 * @return employee Id
	 */
	public String getEmployeeId() {
		return this.employeeId;
	}
	
	/**
	 * Gets the hourly pay
	 * @return hourly pay
	 */
	public double getPay() {
		return this.hourlyRate;
	}
	
	/**
	 * Gives a raise to the employee
	 * @param raise what to add to their pay
	 */
	public void giveRaise(double raise) {
		this.hourlyRate += raise;
	}
	
	/**
	 * Abstract method to deal with paycheck
	 * @return the paychecks
	 */
	public abstract double paycheck(); 
	
	/**
	 * Overrides to string to create a custom one.
	 */
	@Override
	public String toString() {
		return "Employee Id: " + this.employeeId + ", Employee Name: " + this.employeeName + ", Current Hourly Pay: " + this.hourlyRate;
	}

}
