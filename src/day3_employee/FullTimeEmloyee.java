package day3_employee;

public class FullTimeEmloyee extends Employee{
    private final long monthlySalary;

    public FullTimeEmloyee(long id, String name, long monthlySalary){
        super(id, name);
        if(monthlySalary <= 0){
            throw new IllegalArgumentException("Monthly Salary must be > 0");
        }
        this.monthlySalary = monthlySalary;
    }

    public long getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public long calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void printInfo(){
        System.out.println("ID: " + this.getId() + "; Name: " + this.getName() + "; Type: Fulltime"
                + "; Salary: " + calculateSalary());
    }
}
