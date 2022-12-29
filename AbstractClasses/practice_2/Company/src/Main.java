import java.util.Scanner;

public class Main {

    private static String command;

    public static void main(String[] args) {
        Company company = new Company();
        Scanner scanner = new Scanner(System.in);
        generator(company);
        System.out.println(company.employees.size());
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                command = input;
                company.getIncome(120003452);
                getCommand(command, company);
            }
        }
    }

    public static String getCommand(String command, Company company) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "Hire Operator":
                System.out.println("Введите ФИО, затем заработную плату");
                Operator operator = new Operator(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company);
                company.hire(operator);
                break;
            case "Hire Manager":
                System.out.println("Введите ФИО, затем заработную плату");
                Manager manager = new Manager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company);
                company.hire(manager);
                break;
            case "Hire Topmanager":
                System.out.println("Введите ФИО, затем заработную плату");
                TopManager topManager = new TopManager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company);
                company.hire(topManager);
                break;
            case "Highest salaries":
                company.count = scanner.nextInt();
                company.getTopSalaryStaff(company.count);
                break;
            case "Lowest salaries":
                company.count = scanner.nextInt();
                company.getLowestSalaryStaff(company.count);
                break;
            case "Fire":
                System.out.println("Введите должность");
                String jobTitle = scanner.nextLine();
                if (jobTitle.equals("Operator")) {
                    System.out.println("Введите ФИО, затем З.П.");
                    Operator fireOperator = new Operator(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextInt(), company);
                    company.fire(fireOperator);
                } else if (jobTitle.equals("Manager")) {
                    System.out.println("Введите ФИО, затем З.П.");
                    Manager fireManager = new Manager(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextInt(), company);
                    company.fire(fireManager);
                } else if (jobTitle.equals("Topmanager")) {
                    System.out.println("Введите ФИО, затем З.П.");
                    TopManager fireTopManager = new TopManager(scanner.nextLine(), scanner.nextLine(),
                            scanner.nextLine(), scanner.nextInt(), company);
                    company.fire(fireTopManager);
                }
                break;
            case "List" :
                System.out.println(company);
                break;
            default:
        }
        return "";
    }

    public static void generator(Company company) {
        String[] maleName = {"Иван", "Петр", "Алексей", "Александр", "Валерий", "Никита", "Вениамин", "Виктор", "Рэм",
                "Савва"};
        String[] malePatronymic = {"Иванович", "Васильевич", "Алекандрович", "Никандрович", "Вениаминович", "Сергеевич",
                "Савельевич"};
        String[] maleSurName = {"Иванов", "Васильев", "Александров", "Никандров", "Феоктистов", "Титов", "Столбов",
                "Савельев"};
        String[] femaleName = {"Мария", "Марина", "Виктория", "Алина", "Валерия", "Наталья", "Яна", "Лидия", "Анна"};
        String[] femalePatronymic = {"Ивановна", "Васильевна", "Александровна", "Валерьевна", "Вениаминовна",
                "Никитична"};
        String[] femaleSurname = {"Иванова", "Петрова", "Александрова", "Ильина", "Васильева", "Сергеева", "Ларина"};
        int operatorSalary = 130700;
        int managerSalary = 150000;
        int topManagerSalary = 180000;
        company.getIncome(120003452);

        for (String name : maleName) {
            for (String patronymic : malePatronymic) {
                for (String surName : maleSurName) {
                    if (company.employees.size() < 90) {
                        Operator operator = new Operator(name, patronymic, surName, operatorSalary, company);
                        company.hire(operator);
                    }
                    if (company.employees.size() >= 90 && company.employees.size() < 130) {
                        Manager manager = new Manager(name, patronymic, surName, managerSalary, company);
                        company.hire(manager);
                    }
                    if (company.employees.size() >= 130 && company.employees.size() < 135) {
                        TopManager topManager = new TopManager(name, patronymic, surName, topManagerSalary, company);
                        company.hire(topManager);
                    }
                    if (company.employees.size() == 135) {
                        break;
                    }
                }
            }
        }
        for (String name : femaleName) {
            for (String patronymic : femalePatronymic) {
                for (String surName : femaleSurname) {
                    if (company.employees.size() < 225) {
                        Operator operator = new Operator(name, patronymic, surName, operatorSalary, company);
                        company.hire(operator);
                    }
                    if (company.employees.size() >= 225 && company.employees.size() <= 265) {
                        Manager manager = new Manager(name, patronymic, surName, managerSalary, company);
                        company.hire(manager);
                    }
                    if (company.employees.size() > 265 && company.employees.size() < 270) {
                        TopManager topManager = new TopManager(name, patronymic, surName, topManagerSalary, company);
                        company.hire(topManager);
                    }
                    if (company.employees.size() == 270) {
                        break;
                    }
                }
            }
        }
    }
}