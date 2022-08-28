public class Operator extends Company implements Employee{

    private final String name;
    private final String surName;
    private final String family;
    private  double monthSalary;

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
    public void setMonthSalary (double monthSalary) {
    }
    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    public String toString() {
        return name + "  " + surName + "  " + family + "  " + "ќператор" + "  з.п.: " + monthSalary;
    }
}
