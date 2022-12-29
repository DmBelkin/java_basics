
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
        return monthSalary + (int)(company.income * 0.005);
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
    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getPatronymic() + "  " + getSurname() + "  " + "��������" + "  �.�.: "
                + getMonthSalary();
        return toString;
    }
}
