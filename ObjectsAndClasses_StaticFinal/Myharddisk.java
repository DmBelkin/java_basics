public class Myharddisk {

    private static Harddisktype harddisktype;
    private final int memorySize;
    private final int weight;

    public Myharddisk(Harddisktype harddisktype, int memorySize, int weight) {
        this.harddisktype = harddisktype;
        this.memorySize = memorySize;
        this.weight = weight;
    }
    public static Harddisktype getHarddisktype() {
        return harddisktype;
    }
    public int getMemorySize() {
        return memorySize;
    }
    public int getWeight() {
        return weight;
    }
    public String print() {
        String print = "Тип: " + getHarddisktype() + "\n" + "Объем: " + getMemorySize() + "Gb" + "\n" +
                "Вес: " + getWeight() + "g";
        System.out.println("Монитор: ");
        System.out.println(print);
        System.out.println();
        return print;
    }


}
