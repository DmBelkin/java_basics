
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

    public void getTotalWeight() {
        int totalWeight = keyboard.getKeyboardWeight() + monitor.getMonitorWeight() + harddisk.getHdWeight() +
                ram.getRamWeight() + processor.getCpuWeight();
        System.out.println("��������� ��� ���������: " + totalWeight);
    }

    public String toString() {
        String toString = "���� ������������ : " + "\n" + "�������������: " + vendor + "\n" +
                "�����: " + name + "\n";
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
