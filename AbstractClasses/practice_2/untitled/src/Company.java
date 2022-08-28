import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    protected ArrayList<Employee> employees = new ArrayList<>();
    protected  ArrayList<Double> sortedSalaryStaff = new ArrayList<>();
    protected static int count;
    protected static double income;

    public Company() {
    }

    public List<Employee> getTopSalaryStaff(int count) {
        for (Employee employeeInfo : employees) {
            sortedSalaryStaff.add(employeeInfo.getMonthSalary());
        }
        Collections.sort(sortedSalaryStaff);
        for (int i = sortedSalaryStaff.size() - 1; i >= sortedSalaryStaff.size() - count; i--) {
            System.out.println(sortedSalaryStaff.get(i));
        }
        return new ArrayList<>();
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        for (Employee employeeInfo1 : employees) {
            sortedSalaryStaff.add(employeeInfo1.getMonthSalary());
        }
        Collections.sort(sortedSalaryStaff);
        for (int i = 1; i <= count; i++) {
            System.out.println(sortedSalaryStaff.get(i));
        }
        return new ArrayList<>();
    }

    public Employee hire(Employee employee) {
        employees.add(employee);
        System.out.println(employee);
        return new Employee() {
            @Override
            public double getMonthSalary() {
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
            public double getMonthSalary() {
                return 0;
            }
        };
    }

    public double getIncome() {
        income = 20000000 * Math.random();
        return income;
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
