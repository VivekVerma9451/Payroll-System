import java.util.ArrayList;

abstract  class Employee{
    private String name;
    private  int id;

    public  Employee(String name,int  id){ //constructor
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return  name;
    }

    public  int getId(){
        return  id;
    }
    public abstract  double calsalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ",salary=" + calsalary() + "]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlysalary;
    public FullTimeEmployee(String name,int id, double monthlysalary){
        super(name,id);
        this.monthlysalary=monthlysalary;
    }
    @Override
    public double calsalary(){ //override is liye liya kyoki wo abstract hai
        return  monthlysalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursworked,double hourlyRate){
        super(name,id);
        this.hoursworked=hoursworked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calsalary(){
        return hourlyRate*hoursworked;
    }
}

class  PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

    public class Main {
        public static void main(String[] args)
        {
            PayrollSystem payrollSystem=new PayrollSystem();
            FullTimeEmployee emp1=new FullTimeEmployee("Vikas",1,70000.0);
            PartTimeEmployee emp2=new PartTimeEmployee("Vivek",2,40,100);

            payrollSystem.addEmployee(emp1);
            payrollSystem.addEmployee(emp2);
            System.out.println("Intial Employee Details: ");
            payrollSystem.displayEmployees();
            System.out.println("Removing Employee");
            payrollSystem.removeEmployee(2);
            System.out.println("Reamining Employeee Details: ");
            payrollSystem.displayEmployees();
        }
    }
