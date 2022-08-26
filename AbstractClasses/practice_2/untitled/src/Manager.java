
public class Manager extends Operator implements Employee {



    public Manager (String name, String surName, String family, double salary) {
        super(name, surName, family, salary);
    }

    @Override
    public Operator setMonthSalary(double monthSalary) {
        monthSalary = super.getIncome() > 10000000 ? monthSalary + (1.5 * monthSalary) : monthSalary;
        return super.setMonthSalary(monthSalary);
    }


    @Override
    public String toString() {
        String toString = getName() + "  " + getSurName() + "  " + getFamily() + "  " + "Менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
