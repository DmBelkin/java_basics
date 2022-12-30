
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Resizer extends Thread {

    private final String dstFolder = "C:/Desktop/dst/";
    private ArrayList<File> collect;
    private final int targetSize = 300;
    private BufferedImage image;

    public Resizer(ArrayList<File> collect) {
        this.collect = collect;
    }

    @Override
    public void run() {
        try {
            for (File file : collect) {
                image = ImageIO.read(file);
                BufferedImage resizedImage = Scalr.resize(image, targetSize);

                File file1 = new File(dstFolder + "/" + file.getName());
                ImageIO.write(resizedImage, "jpg", file1);

                image.flush();
                resizedImage.flush();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
