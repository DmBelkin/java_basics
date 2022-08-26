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
            case "Operator":
                System.out.println("������� ���, ����� ���������� �����");
                Operator operator = new Operator(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextDouble()
                );
                operator.hire(operator);
                System.out.println(operator);
                break;
            case "Manager":
                System.out.println("������� ���, ����� ���������� �����");
                Manager manager = new Manager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextDouble()
                );
                manager.hire(manager);
                System.out.println(manager);
                break;
            case "Topmanager":
                System.out.println("������� ���, ����� ���������� �����");
                TopManager topManager = new TopManager(
                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt()
                );
                topManager.hire(topManager);
                System.out.println(topManager);
                break;
            case "Highest salaries":
                company.count = scanner.nextInt();
                company.getTopSalaryStaff(company.count);
                break;
            case "Lowest salaries":
                company.count = scanner.nextInt();
                company.getLowestSalaryStaff(company.count);
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
        int topManagerSalary = 180000;

        for (String name : maleName) {
            for (String surName : maleSurName) {
                for (String family : maleFamily) {
                    Operator operator = new Operator(name, surName, family, operatorSalary);
                    Manager manager = new Manager(name, surName, family, managerSalary);
                    TopManager topManager = new TopManager(name, surName, family, topManagerSalary);
                    company.hire(operator);
                    company.hire(manager);
                    company.hire(topManager);
                }
            }
            break;
        }
        for (String name : femaleName) {
            for (String surName : femaleSurName) {
                for (String family : femaleFamily) {
                    Operator operator = new Operator(name, surName, family, operatorSalary);
                    Manager manager = new Manager(name, surName, family, managerSalary);
                    TopManager topManager = new TopManager(name, surName, family, topManagerSalary);
                    company.hire(operator);
                    company.hire(manager);
                    company.hire(topManager);
                }
            }
            break;
        }
    }
}
