
public class Manager implements Employee {

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;

    public Manager (String name, String patronymic, String surName, int monthSalary) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
    }

    @Override
    public int getMonthSalary() {
        return monthSalary + (int)(Company.income * 0.005);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surName;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getPatronymic() + "  " + getSurname() + "  " + "Менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
