

public class Computer {

    private final String vendor;
    private final String name;
//����������
    private final int keysWeight = 0;
    private final String keysType = "";
    private final String keysLight = "";
//����������� ������
    private final String ramType = "";
    private final int ramMemorySize = 0;
    private final int ramWeight = 0;
//�������
    private final String monitorType = "";
    private final int diag = 0;
    private final int monitorWeight = 0;
//������� ����
    private final String hardDiskType = "";
    private final int hdMemorySize = 0;
    private final int hdWeight = 0;
//���������
    private final String manufacturer = "";
    private final double frequency = 0;
    private final int coreCount = 0;
    private final int cpuWeight = 0;

    public static int totalweight;


    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

//    public String setKeyboard() {
//        keysLight = Keyboard.getLight(KeyboardLight.valueOf());
//        System.out.println("����������: ");
//        String print = "���������: " + keysLight + "\n" + "���: " + keysType + "\n" + "���: " + keysWeight + "g";
//        System.out.println(print);
//        System.out.println();
//        Computer.totalweight = Computer.totalweight + keysWeight;
//        return keysLight;
//    }

    public void addRam(String ramType, int memorySize, int ramWeight) {
        Ram ram = new Ram(Ramtype.valueOf("DDR4"), 4, 56);
        String print = "���: " + ramType + "\n" + "�����: " + memorySize + "Gb" + "\n" + "���: " + ramWeight + "g";
        System.out.println("����������� ������: ");
        System.out.println(print);
        System.out.println();
        Computer.totalweight = Computer.totalweight + ramWeight;
    }

    public void addMonitor(String monitorType, int diag, int monitorWeight ) {
        Mymonitor mymonitor = new Mymonitor(Monitortype.valueOf("VA"), 17, 2300);
        String print = "���: " + monitorType + "\n" + "���������: " + diag + "'" + "\n" + "���: " + monitorWeight + "g";
        System.out.println("�������: ");
        System.out.println(print);
        System.out.println();
        Computer.totalweight = Computer.totalweight + monitorWeight;
    }

    public void addHarddisk(String hardDiskType, int hdMemorySize, int hdWeight) {
        Myharddisk myharddisk = new Myharddisk(Harddisktype.valueOf("HDD"), 500, 230);
        String print = "���: " + hardDiskType + "\n" + "�����: " + hdMemorySize + "Gb" + "\n" +
                "���: " + hdWeight + "g";
        System.out.println("������� ����: ");
        System.out.println(print);
        System.out.println();
        Computer.totalweight = Computer.totalweight + hdWeight;
    }

    public void addCpu(String manufacturer, double frequency, int coreCount, int cpuWeight) {
        Mycpu mycpu = new Mycpu(Manufacturer.valueOf("INTEL"), 2700, 75, 4);
        String print = "�������������: " + manufacturer + "\n" + "�������� �������: " + frequency + "GHz" +
                "\n" + "���������� ����: " + coreCount+ "\n" + "���: " + cpuWeight+ "g";
        System.out.println("���������: ");
        System.out.println(print);
        System.out.println();
        Computer.totalweight = Computer.totalweight + cpuWeight;
    }
    public static void setTotalweight(int totalweight) {
        Computer.totalweight = Computer.totalweight + totalweight;
    }
    public static int getTotalweight() {
        return totalweight;
    }
    public static void cleanTotalWeight() {
        totalweight = 0;

    }
    public String toString() {
        String toString = "���� ������������ : " + "\n" + "�������������: " + vendor + "\n" +
                "�����: " + name + "\n" + "��������� ���: " + Computer.totalweight;
        cleanTotalWeight();
        System.out.println(toString);
        System.out.println();
        return toString;
    }
}
