public class Processor {

    private final Manufacturer manufacturer;
    private final double frequency;
    private final int coreCount;
    protected final int cpuWeight;

    public Processor(Manufacturer manufacturer, double frequency, int coreCount, int cpuWeight) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.cpuWeight = cpuWeight;
    }

    public Processor setManufact(Manufacturer manufacturer) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }

    public Manufacturer getManufact() {
        return manufacturer;
    }

     public  Processor setFrequency(double frequency) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }

    public double getFrequency() {
        return frequency;
    }

    public Processor setCores(int coreCount) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }

    public int getCores() {
        return coreCount;
    }

    public Processor setCpuWeight(int cpuWeight) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }

    public int getCpuWeight() {
        return cpuWeight;
    }

    public String toString () {
        System.out.println("Процессор: " + "\n" + "Производтель: " + getManufact() + "\n" + "Тактовая частота:" +
                getFrequency()  + "GHz" + "\n" + "Количество ядер: " + getCores() + "\n" + "Вес: " + getCpuWeight());
        System.out.println();
        return "";
    }
}
