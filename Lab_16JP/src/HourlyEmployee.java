
public class HourlyEmployee extends Employee{

	private double workHours = 0;

	public HourlyEmployee(String name, String id, double pay) {
		super(id, name, pay);
	}

	public void setWorkHours(double work) {
		this.workHours = work;
	}

	@Override
	public double paycheck() {
		if(workHours <= 40) {
			return workHours * getPay(); 
		}else {
			workHours -= 40;
			return workHours * (1.5 * getPay());
		}
	}
	
	@Override
	public String toString() {
		return "Employee Name: " + getEmployeeName() + ", Employee Id: " + getEmployeeId() + ", Pay check: " + paycheck();
	}

}
