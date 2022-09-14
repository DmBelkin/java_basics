import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        LocalDate newYear = LocalDate.of(year, 1 , 1);
        Optional<Employee> o = staff.stream().filter(employee ->
                        employee.getWorkStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(newYear)).
                max(Comparator.comparing(Employee::getSalary));
        Employee employee = o.get();
        return employee ;
    }
}