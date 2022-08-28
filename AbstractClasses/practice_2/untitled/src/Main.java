import java.util.Scanner;

public class Main {

    private static Company company = new Company();

    private static String command;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generator(company);
        System.out.println(company);
        System.out.println(company.employees.size());
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else {
                command = input;
                getCommand(command);

            }
        }
    }

    public static String getCommand(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "Hire Operator":
                System.out.println("������� ���, ����� ���������� �����");
                Operator operator = new Operator(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextDouble()
                );
                company.hire(operator);
                break;
            case "Hire Manager":
                System.out.println("������� ���, ����� ���������� �����");
                Manager manager = new Manager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextDouble()
                );
                company.hire(manager);
                break;
            case "Hire Topmanager":
                System.out.println("������� ���, ����� ���������� �����");
                TopManager topManager = new TopManager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt()
                );
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
                System.out.println("������� ���������");
                String jobTitle = scanner.nextLine();
                if (jobTitle.equals("Operator")) {
                    System.out.println("������� ���, ����� �.�.");
                    Operator compOperator = new Operator(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextDouble());
                    company.fire(compOperator);
                } else if (jobTitle.equals("Manager")) {
                    System.out.println("������� ���, ����� �.�.");
                    Manager compManager = new Manager(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextDouble());
                    company.fire(compManager);
                } else if (jobTitle.equals("Topmanager")) {
                    System.out.println("������� ���, ����� �.�.");
                    TopManager compTopManager = new TopManager(scanner.nextLine(), scanner.nextLine(),
                            scanner.nextLine(), scanner.nextDouble());
                    company.fire(compTopManager);
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
        String[] maleName = {"����", "����", "�������", "���������", "�������", "������", "��������", "������", "���",
                "�����"};
        String[] maleSurName = {"��������", "����������", "������������", "�����������", "������������", "���������",
                "����������"};
        String[] maleFamily = {"������", "��������", "�����������", "���������", "����������", "�����", "�������",
                "��������"};
        String[] femaleName = {"�����", "������", "��������", "�����", "�������", "�������", "���", "�����", "����"};
        String[] femaleSurName = {"��������", "����������", "�������������", "����������", "������������", "���������"};
        String[] femaleFamily = {"�������", "�������", "������������", "������", "���������", "��������", "������"};
        double operatorSalary = 130700;
        double managerSalary = 150000;
        double topManagerSalary = 180000;

        for (String name : maleName) {
            for (String surName : maleSurName) {
                for (String family : maleFamily) {
                    if (company.employees.size() < 90) {
                        Operator operator = new Operator(name, surName, family, operatorSalary);
                        company.hire(operator);
                    }
                    if (company.employees.size() >= 90 && company.employees.size() < 130) {
                        Manager manager = new Manager(name, surName, family, managerSalary);
                        company.hire(manager);
                    }
                    if (company.employees.size() >= 130 && company.employees.size() < 135) {
                        TopManager topManager = new TopManager(name, surName, family, topManagerSalary);
                        company.hire(topManager);
                    }
                    if (company.employees.size() == 135) {
                        break;
                    }
                }
            }
        }
        for (String name : femaleName) {
            for (String surName : femaleSurName) {
                for (String family : femaleFamily) {
                    if (company.employees.size() < 225) {
                        Operator operator = new Operator(name, surName, family, operatorSalary);
                        company.hire(operator);
                    }
                    if (company.employees.size() >= 225 && company.employees.size() <= 265) {
                        Manager manager = new Manager(name, surName, family, managerSalary);
                        company.hire(manager);
                    }
                    if (company.employees.size() > 265 && company.employees.size() < 270) {
                        TopManager topManager = new TopManager(name, surName, family, topManagerSalary);
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