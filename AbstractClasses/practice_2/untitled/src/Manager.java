
public class Manager implements Employee {

    private final String name;
    private final String surName;
    private final String family;
    private int monthSalary;

    public Manager (String name, String surName, String family, int monthSalary) {
        this.name = name;
        this.surName = surName;
        this.family = family;
        this.monthSalary = monthSalary;
    }

    @Override
    public int getMonthSalary() {
        monthSalary = monthSalary + (int)(Company.income * 0.005);
        return monthSalary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getSurName() + "  " + getFamily() + "  " + "Менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
