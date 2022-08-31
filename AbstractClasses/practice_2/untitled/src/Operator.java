public class Operator implements Employee{

    private final String name;
    private final String surName;
    private final String family;
    private int monthSalary;

    public Operator (String name, String surName, String family, int monthSalary) {
        this.name = name;
        this.surName = surName;
        this.family = family;
        this.monthSalary = monthSalary;
    }
    @Override
    public String getName () {
        return  name;
    }
    @Override
    public String getSurName () {
        return  surName;
    }
    @Override
    public String getFamily () {
        return family;
    }
    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
    @Override
    public String toString() {
        return name + "  " + surName + "  " + family + "  " + "ќператор" + "  з.п.: " + monthSalary;
    }
}
