
public class main {

    public static void main(String[] args){


        Computer computer = new Computer("Acer", "HighSpeed",
                new Keyboard(KeyboardType.valueOf("GAMER"), KeyboardLight.valueOf("RED"), 230),
                new Ram(Ramtype.valueOf("DDR4"), 4, 34),
                new Monitor(Monitortype.valueOf("VA"), 17, 2300),
                new Harddisk(Harddisktype.valueOf("SSD"), 2000, 156),
                new Processor(Manufacturer.valueOf("INTEL"), 2.7, 4, 56));
        computer.toString();
        System.out.println();

        Computer computer1 = new Computer("Acer", "HomeMaster",
                new Keyboard(KeyboardType.valueOf("OFFICE"), KeyboardLight.valueOf("GREEN"), 340),
                new Ram(Ramtype.valueOf("DDR2"), 256, 54),
                new Monitor(Monitortype.valueOf("IPS"), 19, 1720),
                new Harddisk(Harddisktype.valueOf("HDD"), 500, 300),
                new Processor(Manufacturer.valueOf("AMD"), 1.8, 2, 75));
        computer1.toString();
        System.out.println();

        Computer computer2 = new Computer("Lenovo", "School",
                new Keyboard(KeyboardType.valueOf("ERGONOMIC"), KeyboardLight.valueOf("PHIOLENT"), 400),
                new Ram(Ramtype.valueOf("DDR3"), 2, 49),
                new Monitor(Monitortype.valueOf("TN"), 22, 1900),
                new Harddisk(Harddisktype.valueOf("SSD"), 250, 134),
                new Processor(Manufacturer.valueOf("ALTERA"), 2.2, 4, 86));
        computer2.toString();
        System.out.println();



    }
}
