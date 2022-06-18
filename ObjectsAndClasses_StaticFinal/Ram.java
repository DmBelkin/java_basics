import java.util.PrimitiveIterator;

public class Ram {

    public static Ramtype ramtype;
    private final int memorySize;
    private final int weight;

    public Ram (Ramtype ramtype, int memorySize, int weight) {
        this.ramtype = ramtype;
        this.memorySize = memorySize;
        this.weight = weight;
    }
    public static Ramtype getRamtype() {
        ramtype = Ramtype.valueOf("DDR3");
        return ramtype;
    }
    public int getMemorySize() {
        return memorySize;
    }
    public int getWeight() {
        return weight;
    }
    public String print() {
        System.out.println("Оперативная память: ");
        String print = "Тип: " + getRamtype() + "\n" + "Объем: " + getMemorySize() + "Gb" + "\n" + "Вес: " + getWeight() + "g";
        System.out.println(print);
        System.out.println();
        return print;
    }

}


