import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    protected ArrayList<Employee> employees = new ArrayList<>();
    protected static int count;
    protected static double income;

    public Company() {
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> comparator = (Employee o1, Employee o2) -> o2.getMonthSalary() - o1.getMonthSalary();
        Collections.sort(employees, comparator);
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Comparator<Employee> comparator = (Employee o1, Employee o2) -> o2.getMonthSalary() - o1.getMonthSalary();
        Collections.sort(employees, comparator);
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

            @Override
            public String getName() {
                return getName();
            }

            @Override
            public String getSurName() {
                return getSurName();
            }

            @Override
            public String getFamily() {
                return getFamily();
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

           @Override
           public String getName() {
               return null;
           }

           @Override
           public String getSurName() {
               return null;
           }

           @Override
           public String getFamily() {
               return null;
           }
       };
    }

    public double getIncome() {
        income = 12345768;
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
