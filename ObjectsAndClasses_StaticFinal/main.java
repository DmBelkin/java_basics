

public class main {

    public static void main(String[] args){

        Computer computer = new Computer("Asus", "Aspire");
        computer.toString();
        computer.addKeyboard();
        computer.addMonitor();
        computer.addRam();
        computer.addCpu();
        computer.addHarddisk();

        Computer computer1 = new Computer("Sony", "Vaio");
        computer1.toString();
        computer1.addKeyboard();
        computer1.addMonitor();
        computer1.addRam();
        computer1.addCpu();
        computer1.addHarddisk();

    }
}
