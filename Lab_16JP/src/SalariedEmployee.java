
public class SalariedEmployee extends Employee{

	private double annualSalary = 0;
	
	public SalariedEmployee(String id, String name, double rate) {
		super(id, name, rate);
	}

	public void setAnnualSalary(double salary) {
		this.annualSalary = salary;
	}
	
	@Override
	public double paycheck() {
		return (annualSalary/52);
	}
	
	@Override
	
	public String toString() {
		return "Employee Name: " + getEmployeeName() + ", Employee Annual Salary: " + this.annualSalary + " Employee Pay: " + paycheck();
	}

	
	
}
