public class TopManager implements Employee {

    private final String name;
    private final String surName;
    private final String family;
    private int monthSalary;

    public TopManager (String name, String surName, String family, int monthSalary) {
        this.name = name;
        this.surName = surName;
        this.family = family;
        this.monthSalary = monthSalary;
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
    public int getMonthSalary() {
        if (Company.income > 10000000) {
            monthSalary = monthSalary + (int)(monthSalary * 1.5);
        }
        return monthSalary;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getSurName() + "  " + getFamily() + "  " + "Топ менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
