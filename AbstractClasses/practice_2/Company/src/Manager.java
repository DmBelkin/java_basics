
public class Manager implements Employee {

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;
    private Company company;

    public Manager (String name, String patronymic, String surName, int monthSalary, Company company) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return monthSalary + (int)(company.getIncome() * 0.005);
    }


    public String getName() {
        return name;
    }

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
