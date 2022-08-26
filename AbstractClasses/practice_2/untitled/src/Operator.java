public class Operator extends Company implements Employee{

    private final String name;
    private final String surName;
    private final String family;
    private final double monthSalary;

    public Operator (String name, String surName, String family, double monthSalary) {
        this.name = name;
        this.surName = surName;
        this.family = family;
        this.monthSalary = monthSalary;
    }

    public Operator setName (String name) {
        return new Operator(name, surName, family, monthSalary);
    }

    public String getName () {
        return  name;
    }
    public Operator setSurname (String surName) {
        return new Operator(name, surName, family, monthSalary);
    }

    public String getSurName () {
        return  surName;
    }
    public Operator setFamily (String family) {
        return new Operator(name, surName, family, monthSalary);
    }

    public String getFamily () {
        return family;
    }
    public Operator setMonthSalary (double monthSalary) {
        return new Operator(name, surName, family, monthSalary);
    }

    public String toString() {
        return name + "  " + surName + "  " + family + "  " + "ќператор" + "  з.п.: " + getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }
}
