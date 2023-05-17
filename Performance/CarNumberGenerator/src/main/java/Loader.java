import java.util.concurrent.CountDownLatch;

public class Loader{


    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(12);
        char[] letters = {'У','К','Е','Н','Х','В','А','Р','О','С','М','Т'};
        for (int number = 0; number < letters.length; number++) {
           Generator generator = new Generator(letters[number], number, latch);
           generator.start();
        }
        latch.await();
        System.out.println((System.currentTimeMillis() - start) + " ms");
        //изначальный вариант более 23 секунд
        //после оптимизации 1400 ms
        //буфферизация по длине strinbuilder 10000- 4 секунды
    }
}
