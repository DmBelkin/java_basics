
public class Computer {

    private final String vendor;
    private final String name;
    //����������
    private final Keyboard keyboard;
    //����������� ������
    private final Ram ram;
    //�������
    private final Monitor monitor;
    //������� ����
    private final Harddisk harddisk;
    //���������
    private final Processor processor;

    public static int totalweight = getTotalweight();


    public Computer(String vendor, String name, Keyboard keyboard, Ram ram, Monitor monitor, Harddisk harddisk, Processor processor) {
        this.vendor = vendor;
        this.name = name;
        this.keyboard = keyboard;
        this.ram = ram;
        this.monitor = monitor;
        this.harddisk = harddisk;
        this.processor = processor;
    }
    public Computer setVendor(String vendor) {
        return new Computer(vendor, name, keyboard, ram,
                monitor, harddisk, processor);
    }
    public String getVendor() {
        return vendor;
    }
    public Computer setName(String name) {
        return new Computer(vendor, name, keyboard, ram,
                monitor, harddisk, processor);
    }
    public String getName() {
        return name;
    }

    public static int getTotalweight() {
//        int keysWeight = Keyboard.
        return totalweight;
    }

    public String toString() {
        String toString = "���� ������������ : " + "\n" + "�������������: " + vendor + "\n" +
                "�����: " + name + "\n" + "��������� ���: " + totalweight;
        System.out.println(toString);
        System.out.println();
        System.out.println(keyboard.print(""));
        System.out.println();
        System.out.println(ram.print(""));
        System.out.println();
        System.out.println(harddisk.print(""));
        System.out.println();
        System.out.println(processor.print(""));
        System.out.println();
        System.out.println(monitor.print(""));
        return toString;
    }
}
