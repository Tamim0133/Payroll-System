import java.util.*;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){ // encapsulation , getters
        return this.name;
    }
    public int getId(){
        return this.id;
    }

    public abstract double calculateSalary(); // abstract method just declare kore rekhe dei. ei class ke jekhane extend ba inherit korbo oikhane body dibo
    @Override // polymorphism
    public String toString(){
        return "Employee[name="+name+",id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        this.employeeList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!= null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}


public class Main{
    public static void main(String[] args){
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.addEmployee(new FullTimeEmployee("John", 1, 10000));
        payrollSystem.addEmployee(new PartTimeEmployee("Mary", 2, 10, 100));
        payrollSystem.addEmployee(new FullTimeEmployee("Peter", 3, 10000));
        payrollSystem.addEmployee(new PartTimeEmployee("Lisa", 4, 10, 100));
        payrollSystem.addEmployee(new FullTimeEmployee("Sara", 5, 10000));
        payrollSystem.addEmployee(new PartTimeEmployee("Nancy", 6, 10, 100));

        System.out.println("Initial Employess : ");
        payrollSystem.displayEmployees();

        payrollSystem.removeEmployee(1);
        
        System.out.println("Remainning Employess : ");
        payrollSystem.displayEmployees();


    }
}