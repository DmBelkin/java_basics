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


    public Manufacturer getManufact() {
        return manufacturer;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return coreCount;
    }


    public int getCpuWeight() {
        return cpuWeight;
    }

    public String toString () {
        return "���������: " + "\n" + "������������: " + getManufact() + "\n" + "�������� �������:" +
                getFrequency()  + "GHz" + "\n" + "���������� ����: " + getCores() + "\n" + "���: " + getCpuWeight() +
                "\n";
    }
}
