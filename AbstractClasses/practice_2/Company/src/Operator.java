public class Operator implements Employee{

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;

    private Company company;

    public Operator (String name, String patronymic, String surName, int monthSalary, Company company) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
        this.company = company;
    }
    @Override
    public String getName () {
        return  name;
    }
    @Override
    public String getPatronymic () {
        return  patronymic;
    }
    @Override
    public String getSurname () {
        return surName;
    }
    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
    @Override
    public Company getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return name + "  " + patronymic + "  " + surName + "  " + "ќператор" + "  з.п.: " + monthSalary;
    }
}
