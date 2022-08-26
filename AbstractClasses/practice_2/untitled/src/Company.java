import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    protected ArrayList <Employee> employees = new ArrayList<>();

    protected static int count;

    Employee employee;

    protected static double income;

    public Company() {
    }

    public List<Employee> getTopSalaryStaff (int count) {
        ArrayList<Double> sortedSalaryStaff = new ArrayList<>();
        for (Employee employeeInfo : employees) {
            sortedSalaryStaff.add(employeeInfo.getMonthSalary());
            if (sortedSalaryStaff.size() == count) {
                break;
            }
        }
        Collections.sort(sortedSalaryStaff);
        for (int i = 0; i <= sortedSalaryStaff.size() - 1; i++)  {
            System.out.println(sortedSalaryStaff.get(i));
    }
        return new ArrayList<>();
    }

    public List<Employee> getLowestSalaryStaff (int count) {
        ArrayList<Double> sortedSalaryStaff = new ArrayList<>();
        for (Employee employeeInfo : employees) {
            sortedSalaryStaff.add(employeeInfo.getMonthSalary());
            if (sortedSalaryStaff.size() == count) {
                break;
            }
        }
        Collections.sort(sortedSalaryStaff);
        for (int i = 0; i <= sortedSalaryStaff.size() - 1; i++)  {
            System.out.println(sortedSalaryStaff.get(i));
        }
        return  new ArrayList<>();
    }

    public Employee hire (Employee employee) {
        employee.getMonthSalary();
        employees.add(employee);
      return new Employee() {
          @Override
          public double getMonthSalary() {
              return 0;
          }
      };
    }

    public Employee fire(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
        return new Employee() {
            @Override
            public double getMonthSalary() {
                return 0;
            }
        };
    }

    public double getIncome() {
        income = 15000000 * Math.random();
        return income;
    }

    public String  toString() {
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
