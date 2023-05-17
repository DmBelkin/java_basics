
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public class Generator extends Thread {

    private char letter;

    private final int regionCode = 199;

    private String fileName = "res/numbers";

    private final char[] letters = {'Ó', 'Ê', 'Å', 'Í', 'Õ', 'Â', 'À', 'Ð', 'Î', 'Ñ', 'Ì', 'Ò'};

    private int fileNumber;

    private CountDownLatch latch;


    public Generator(char letter, int fileNumber, CountDownLatch latch) {
        this.letter = letter;
        this.fileNumber = fileNumber;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        String carNumber = "" + letter + padNumber(number) + secondLetter + thirdLetter
                                + regionCode;
                        builder.append(carNumber + System.lineSeparator());
//                        if (builder.length() % 10000 == 0) {
//                            fileWriter(builder, fileNumber);
//                        }
                    }
                }
            }
            fileWriter(builder, fileNumber);
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileWriter(StringBuilder builder, int number) throws IOException {
        String[] result = builder.toString().split("\r\n");
//        FileWriter writer = new FileWriter(fileName + number + ".txt", true);
        PrintWriter writer = new PrintWriter(fileName + number + ".txt");
        for (String s : result) {
            writer.write(s + "\n");
        }
        writer.flush();
        writer.close();
    }

    private String padNumber(int number) {
        String num = Integer.toString(number);
        if (num.length() == 1) {
            return "00" + number;
        } else if (num.length() == 2) {
            return "0" + number;
        }
        return num;
    }
}
