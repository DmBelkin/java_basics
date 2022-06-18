public class Mycpu {

    private static Manufacturer manufacturer;
    private final double frequency;
    private final int weight;
    private final int coreCount;

    public Mycpu (Manufacturer manufacturer, double frequency, int weight, int coreCount) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.weight = weight;
        this.coreCount = coreCount;
    }
    public static Manufacturer getManufacturer() {
        manufacturer = Manufacturer.valueOf("ALTERA");
        return manufacturer;
    }
    public int getCoreCount() {
        return coreCount;
    }
    public  int getWeight() {
        return weight;
    }
    public double getFrequency() {
        return frequency;
    }
    public String print() {
        String print = "Производитель: " + getManufacturer() + "\n" + "Тактовая частота: " + getFrequency() + "GGz" +
                "\n" + "Количество ядер: " + getCoreCount() + "\n" + "Вес: " + getWeight() + "g";
        System.out.println("Процессор: ");
        System.out.println(print);
        System.out.println();
        return print;
    }
}
