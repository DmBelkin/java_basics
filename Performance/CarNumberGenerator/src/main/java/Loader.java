import java.util.concurrent.CountDownLatch;

public class Loader{


    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(12);
        char[] letters = {'�','�','�','�','�','�','�','�','�','�','�','�'};
        for (int number = 0; number < letters.length; number++) {
           Generator generator = new Generator(letters[number], number, latch);
           generator.start();
        }
        latch.await();
        System.out.println((System.currentTimeMillis() - start) + " ms");
        //����������� ������� ����� 23 ������
        //����� ����������� 1400 ms
        //������������ �� ����� strinbuilder 10000- 4 �������
    }
}
