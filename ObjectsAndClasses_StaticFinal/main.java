

public class main {

    public static void main(String[] args){

        Computer computer = new Computer("Asus", "Aspire");
        computer.toString();
     //   computer.setKeyboard("RED", "ERGONOMIC", 340);
        computer.addMonitor("IPS", 19, 1590);
        computer.addRam("DDR1", 2, 54);
        computer.addCpu("AMD", 3.2, 4, 57);
        computer.addHarddisk("SSD", 1000, 145);

        Computer computer1 = new Computer("Sony", "Vaio");
        computer1.toString();
     //   computer1.setKeyboard("GREEN", "OFFICE", 560);
        computer1.addMonitor("TN", 15, 4500);
        computer1.addRam("DDR2", 512, 36);
        computer1.addCpu("INTEL", 1.7, 2, 82);
        computer1.addHarddisk("HDD", 320, 279);

        Computer computer2 = new Computer("Lenovo", "IdeaPad");
        computer2.toString();
     //   computer2.setKeyboard("PHIOLENT", "SLIM", 230);
        computer2.addMonitor("VA", 30, 1200);
        computer2.addRam("DDR4", 8, 34);
        computer2.addCpu("INTEL", 2.9, 4, 56);
        computer2.addHarddisk("SSD", 2000, 134);

        Computer computer3 = new Computer("ASUS", "ASPIRE");
        computer3.toString();


    }
}
