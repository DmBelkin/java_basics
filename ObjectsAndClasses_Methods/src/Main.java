

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("������", 40, 5);
        basket.print();
        System.out.println();

        Basket basket1 = new Basket();
        basket1.add("����", 32, 3);
        basket1.add("�������", 124, 2);
        basket1.add("����", 459, 1);
        basket1.add("�����", 1280, 1);
        basket1.print();
        System.out.println();

        Basket basket2 = new Basket();
        basket2.add("�������", 78, 2);
        basket2.add("������� �������", 532, 3);
        basket2.add("��������", 46, 1);
        basket2.print();
        System.out.println();

//        Basket basket3 = new Basket("�������", 50);
//        basket3.print();
//        System.out.println();

        Session session = new Session();

        System.out.println("����� ���������� �������: " + Basket.getFullItems());
        System.out.println("����� ��������� �������: " + Basket.getFullPrice());
        System.out.println("���������� ������: " + Basket.getCount());
        System.out.println("������� ���� ������� �� ���� ��������: " + Basket.getAveragePrice());

    }
}


