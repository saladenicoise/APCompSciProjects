public abstract class Employee {

	private String employeeId = "";
	private String employeeName = "";
	private String employeeType = "";
	
	/**
	 * Creates a new employee
	 * @param id Employee Id
	 * @param name Employee Name
	 */
	public Employee(String id, String name, String type) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeType = type;
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
	 * Gets the employee type
	 * @return employee type
	 */
	public String getEmployeeType() {
		return this.employeeType;
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
		return "Employee Type: " + this.employeeType + ", Employee Id: " + this.employeeId + ", Employee Name: " + this.employeeName;
	}

}
