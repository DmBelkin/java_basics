import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    private ArrayList<Employee> employees = new ArrayList<>();
    private int count;
    private double income;

    public Company(double income) {
        this.income = income;
    }



    public List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> comparator = (Employee o1, Employee o2) -> o2.getMonthSalary() - o1.getMonthSalary();
        Collections.sort(employees, comparator);
        int check = 0;
        for (Employee employee : employees) {
            check++;
            System.out.println(employee.getMonthSalary());
            if (check == count) {
                break;
            }
        }
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Comparator<Employee> comparator = (Employee o1, Employee o2) -> o2.getMonthSalary() - o1.getMonthSalary();
        Collections.sort(employees, comparator);
        int check = 0;
        for (int i = employees.size() - 1; i >= 0; i--) {
            check++;
            System.out.println(employees.get(i).getMonthSalary());
            if (check == count) {
                break;
            }
        }

        return employees.subList(employees.size() - count, employees.size());

    }

    public Employee hire(Employee employee) {
        employees.add(employee);
        System.out.println(employee);
        return new Employee() {
            @Override
            public int getMonthSalary() {
                return 0;
            }

        };
    }

    public Employee fire(Employee employee) {
        for (int i = 0; i <= employees.size() - 1; i ++) {
            if (employees.get(i).toString().equals(employee.toString())) {
                employees.remove(i);
                System.out.println("Fired");
            }
        }
       return new Employee() {
           @Override
           public int getMonthSalary() {
               return 0;
           }

       };
    }

    public double getIncome() {
        return income;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public String toString() {
        if (employees.isEmpty()) {
            System.out.println("Список пуст");
        }
        String result = "";
        for (Employee employee : employees) {
            result = result + employee.toString() + "\n";
        }
        return result;
    }

}
