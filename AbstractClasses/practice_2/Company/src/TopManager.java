public class TopManager implements Employee {

    private final String name;
    private final String patronymic;
    private final String surName;
    private int monthSalary;

    private Company company;

    public TopManager (String name, String patronymic, String surName, int monthSalary, Company company) {
        this.name = name;
        this.patronymic = patronymic;
        this.surName = surName;
        this.monthSalary = monthSalary;
        this.company = company;
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
        if (company.income > 10000000) {
            return monthSalary + (int)(monthSalary * 1.5);
        }
        return monthSalary;
    }
    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        String toString = getName() + "  " + getPatronymic() + "  " + getSurname() + "  " + "Топ менеджер" + "  з.п.: "
                + getMonthSalary();
        return toString;
    }
}
