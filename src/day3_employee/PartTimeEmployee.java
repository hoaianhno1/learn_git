package day3_employee;

public class PartTimeEmployee extends Employee{
   private final int hourlyRate;
   private final double hoursWorked;

   public PartTimeEmployee(long id, String name, int hourlyRate, double hoursWorked){
       super(id, name);
       if(hourlyRate < 0){
           throw new IllegalArgumentException("Hourly Rate must be > 0");
       }
       if(hoursWorked < 0){
           throw new IllegalArgumentException("Hours Worked must be > 0");
       }

       this.hourlyRate = hourlyRate;
       this.hoursWorked = hoursWorked;
   }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public long calculateSalary() {
        return (long) (hourlyRate * hoursWorked);
    }

    @Override
    public void printInfo(){
        System.out.println("ID: " + this.getId() + "; Name: "
                + this.getName() + "; Type: Part time"
                + "; HourlyRate = " + this.getHourlyRate()
                + "; HourWorked = " + this.getHoursWorked()
                + "; Salary: " + calculateSalary());
    }
}
