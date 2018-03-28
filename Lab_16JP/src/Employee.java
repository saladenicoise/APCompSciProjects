public abstract class Employee {

	private String employeeId = "";
	private String employeeName = "";
	
	/**
	 * Creates a new employee
	 * @param id Employee Id
	 * @param name Employee Name
	 * @param rate Employee's pay
	 */
	public Employee(String id, String name) {
		this.employeeId = id;
		this.employeeName = name;
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
	 * Abstract method to deal with paycheck
	 * @return the paychecks
	 */
	public abstract double paycheck(); 
	
	/**
	 * Overrides to string to create a custom one.
	 */
	@Override
	public String toString() {
		return "Employee Id: " + this.employeeId + ", Employee Name: " + this.employeeName;
	}

}
