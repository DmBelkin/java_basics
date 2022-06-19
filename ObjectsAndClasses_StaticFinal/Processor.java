public class Processor {

    private Manufacturer manufacturer;
    private final double frequency;
    private final int coreCount;
    private final int cpuWeight;

    public Processor(Manufacturer manufacturer, double frequency, int coreCount, int cpuWeight) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.cpuWeight = cpuWeight;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Processor setFrequency(double frequency) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }
    public double getFrequency() {
        return frequency;
    }

    public Processor setCoreCount(int coreCount) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }
    public int getCoreCount() {
        return coreCount;
    }

    public Processor setCpuWeight(int cpuWeight) {
        return new Processor(manufacturer, frequency, coreCount, cpuWeight);
    }
    public int getCpuWeight() {
        return cpuWeight;
    }

    public String print(String print) {
        print = "���������: " + "\n" + "������������: " + manufacturer + "\n" + "�������� �������:" + frequency  + "GHz" +
                "\n" + "���������� ����: " + coreCount +
                     "\n" + "���: " + cpuWeight;
        return print;
    }
}
