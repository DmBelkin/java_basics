public class Operator implements Employee{

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;

    public Operator (String name, String patronymic, String surName, int monthSalary) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
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
    public String toString() {
        return name + "  " + patronymic + "  " + surName + "  " + "ќператор" + "  з.п.: " + monthSalary;
    }
}
