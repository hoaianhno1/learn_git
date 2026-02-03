package day3_employee;

public abstract class Employee {
    private final long id;
    private final String name;

    public Employee(long id, String name) {
        if(id <= 0){
            throw new IllegalArgumentException("Id must be > 0");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is null or blank");
        }
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract long calculateSalary();

    public void printInfo(){
        System.out.println("ID: " + this.getId() + "; Name: " + this.getName()
                                  + "; Salary: " + calculateSalary());

    }
}
