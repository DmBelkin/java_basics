
public class Manager extends Operator implements Employee {

    public Manager (String name, String surName, String family, double salary) {
        super(name, surName, family, salary);
    }

    @Override
    public void setMonthSalary(double monthSalary) {
        super.setMonthSalary(monthSalary);
    }

    @Override
    public double getMonthSalary() {
        return super.getMonthSalary();
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getSurName() + "  " + getFamily() + "  " + "Менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
