

public class Computer {

    private final String vendor;
    private final String name;

    public static int totalWeight;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public void addKeyboard() {
        Keyboard keyboard = new Keyboard(KeyboardLight.GREEN, KeyboardType.GAMER, 340 );
        Computer.totalWeight = Computer.totalWeight + keyboard.getWeight();
        keyboard.print();
    }

    public void addRam() {
        Ram ram = new Ram(Ramtype.DDR3, 2, 58);
        Computer.totalWeight = Computer.totalWeight + ram.getWeight();
        ram.print();
    }

    public void addMonitor() {
        Mymonitor mymonitor = new Mymonitor(17, Monitortype.VA, 2100);
        Computer.totalWeight = Computer.totalWeight + mymonitor.getWeight();
        mymonitor.print();
    }

    public void addHarddisk() {
        Myharddisk myharddisk = new Myharddisk(Harddisktype.SSD, 520, 240);
        Computer.totalWeight = Computer.totalWeight + myharddisk.getWeight();
        myharddisk.print();
    }

    public void addCpu() {
        Mycpu mycpu = new Mycpu(Manufacturer.INTEL, 2.4, 120, 4);
        Computer.totalWeight = Computer.totalWeight + mycpu.getWeight();
        mycpu.print();

    }
    public static int getTotalWeight() {
        return totalWeight;
    }

    public String toString() {
        String toString = "Ваша конфигурация : " + "\n" + "Производитель: " + vendor + "\n" +
                "Серия: " + name + "\n" + "Суммарный вес: " + totalWeight;
        System.out.println(toString);
        System.out.println();
        return toString;
    }
}
