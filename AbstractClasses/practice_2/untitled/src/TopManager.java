public class TopManager implements Employee {

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;

    public TopManager (String name, String patronymic, String surName, int monthSalary) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String getSurname() {
        return surName;
    }

    @Override
    public int getMonthSalary() {
        if (Company.income > 10000000) {
            return monthSalary + (int)(monthSalary * 1.5);
        }
        return monthSalary;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getPatronymic() + "  " + getSurname() + "  " + "Топ менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
