public class TopManager extends Operator implements Employee {


    public TopManager(String name, String surName, String family, double salary) {
        super(name, surName, family, salary);
    }

    @Override
    public void setMonthSalary(double monthSalary) {
        if (super.getIncome() > 10000000) {
            monthSalary = monthSalary + (monthSalary * 1.5);
        }
        super.setMonthSalary(monthSalary);
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
