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
    public String getName () {
        return  name;
    }
    public String getPatronymic () {
        return  patronymic;
    }

    public String getSurname () {
        return surName;
    }
    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
    @Override
    public String toString() {
        return name + "  " + patronymic + "  " + surName + "  " + "ќператор" + "  з.п.: " + monthSalary;
    }
}
