public class TopManager extends Operator implements Employee {



    public TopManager(String name, String surName, String family, int salary) {
        super(name, surName, family, salary);
    }

    @Override
    public Operator setMonthSalary(double monthSalary) {
        monthSalary = monthSalary + ((super.getIncome() * 0.05));
        return super.setMonthSalary(monthSalary);
    }

    @Override
    public double getMonthSalary() {
        return super.getMonthSalary();
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getSurName() + "  " + getFamily() + "  " + "Топ менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
