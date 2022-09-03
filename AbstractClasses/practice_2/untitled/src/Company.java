import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    protected ArrayList<Employee> employees = new ArrayList<>();
    protected static int count;
    protected static double income;

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

            @Override
            public String getName() {
                return getName();
            }

            @Override
            public String getPatronymic() {
                return getPatronymic();
            }

            @Override
            public String getSurname() {
                return getSurname();
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
           public String getPatronymic() {
               return null;
           }

           @Override
           public String getSurname() {
               return null;
           }
       };
    }

    public double getIncome() {
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
