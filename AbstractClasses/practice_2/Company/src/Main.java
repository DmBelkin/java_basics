import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Company company = new Company(13439384.56);
        Scanner scanner = new Scanner(System.in);
        generator(company);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                String command = input;
                company.getIncome();
                getCommand(command, company);
            }
        }
    }

    public static String getCommand(String command, Company company) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "Hire Operator":
                System.out.println("������� ���, ����� ���������� �����");
                Operator operator = new Operator(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company
                );
                company.hire(operator);
                break;
            case "Hire Manager":
                System.out.println("������� ���, ����� ���������� �����");
                Manager manager = new Manager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company
                );
                company.hire(manager);
                break;
            case "Hire Topmanager":
                System.out.println("������� ���, ����� ���������� �����");
                TopManager topManager = new TopManager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), company
                );
                company.hire(topManager);
                break;
            case "Highest salaries":
                company.getTopSalaryStaff(scanner.nextInt());
                break;
            case "Lowest salaries":
                company.getLowestSalaryStaff(scanner.nextInt());
                break;
            case "Fire":
                System.out.println("������� ���������");
                String jobTitle = scanner.nextLine();
                if (jobTitle.equals("Operator")) {
                    System.out.println("������� ���, ����� �.�.");
                    Operator fireOperator = new Operator(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextInt(), company);
                    company.fire(fireOperator);
                } else if (jobTitle.equals("Manager")) {
                    System.out.println("������� ���, ����� �.�.");
                    Manager fireManager = new Manager(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextInt(), company);
                    company.fire(fireManager);
                } else if (jobTitle.equals("Topmanager")) {
                    System.out.println("������� ���, ����� �.�.");
                    TopManager fireTopManager = new TopManager(scanner.nextLine(), scanner.nextLine(),
                            scanner.nextLine(), scanner.nextInt(), company);
                    company.fire(fireTopManager);
                }
                break;
            case "List" :
                System.out.println(company);
                break;
        }
        return "";
    }

    public static void generator(Company company) {
        String[] maleName = {"����", "����", "�������", "���������", "�������", "������", "��������", "������", "���",
                "�����"};
        String[] malePatronymic = {"��������", "����������", "������������", "�����������", "������������", "���������",
                "����������"};
        String[] maleSurName = {"������", "��������", "�����������", "���������", "����������", "�����", "�������",
                "��������"};
        String[] femaleName = {"�����", "������", "��������", "�����", "�������", "�������", "���", "�����", "����"};
        String[] femalePatronymic = {"��������", "����������", "�������������", "����������", "������������", "���������"};
        String[] femaleSurname = {"�������", "�������", "������������", "������", "���������", "��������", "������"};
        int operatorSalary = 130700;
        int managerSalary = 150000;
        int topManagerSalary = 180000;

        for (String name : maleName) {
            for (String patronymic : malePatronymic) {
                for (String surName : maleSurName) {
                    if (company.getEmployees().size() < 90) {
                        Operator operator = new Operator(name, patronymic, surName, operatorSalary, company);
                        company.hire(operator);
                    }
                    if (company.getEmployees().size() >= 90 && company.getEmployees().size() < 130) {
                        Manager manager = new Manager(name, patronymic, surName, managerSalary, company);
                        company.hire(manager);
                    }
                    if (company.getEmployees().size() >= 130 && company.getEmployees().size() < 135) {
                        TopManager topManager = new TopManager(name, patronymic, surName, topManagerSalary, company);
                        company.hire(topManager);
                    }
                    if (company.getEmployees().size() == 135) {
                        break;
                    }
                }
            }
        }
        for (String name : femaleName) {
            for (String patronymic : femalePatronymic) {
                for (String surName : femaleSurname) {
                    if (company.getEmployees().size() < 225) {
                        Operator operator = new Operator(name, patronymic, surName, operatorSalary, company);
                        company.hire(operator);
                    }
                    if (company.getEmployees().size() >= 225 && company.getEmployees().size() <= 265) {
                        Manager manager = new Manager(name, patronymic, surName, managerSalary, company);
                        company.hire(manager);
                    }
                    if (company.getEmployees().size() > 265 && company.getEmployees().size() < 270) {
                        TopManager topManager = new TopManager(name, patronymic, surName, topManagerSalary, company);
                        company.hire(topManager);
                    }
                    if (company.getEmployees().size() == 270) {
                        break;
                    }
                }
            }
        }
    }
}