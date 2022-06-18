public class Myharddisk {

    private final Harddisktype harddisktype;
    private final int memorySize;
    private final int weight;

    public Myharddisk(Harddisktype harddisktype, int memorySize, int weight) {
        this.harddisktype = harddisktype;
        this.memorySize = memorySize;
        this.weight = weight;
    }

    public static Harddisktype getHarddisktype(Harddisktype harddisktype) {
        harddisktype = Harddisktype.valueOf("SSD");
        return harddisktype;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getWeight() {
        return weight;
    }

    public String print() {
        String print = "���: " + harddisktype + "\n" + "�����: " + getMemorySize() + "Gb" + "\n" +
                "���: " + getWeight() + "g";
        System.out.println("�������: ");
        System.out.println(print);
        System.out.println();
        return print;
    }
}
