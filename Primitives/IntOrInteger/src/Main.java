public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for (int i = 1040; i <= 1103; i++) {
            if (i >= 1040 && i < 1046 || i > 1046 && i <= 1077 || i > 1078) {
                char alphabet = (char) i;
                System.out.println(alphabet + "-" + i);
            }
            else if (i == 1046) {
                char yo = (char) 1025;
                char zh = (char) 1046;
                System.out.println(yo + "-" + 1025);
                System.out.println(zh + "-" + i);
            }
            else if (i == 1078) {
                char yo = (char) 1105;
                char zh = (char) 1078;
                System.out.println(yo + "-" + 1105);
                System.out.println(zh + "-" + i);
            }
        }
    }
}
