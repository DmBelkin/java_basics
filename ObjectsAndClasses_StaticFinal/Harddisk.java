

public class Harddisk {

    private final Harddisktype hardDiskType;
    private final int hdMemorySize;
    protected final int hdWeight;

    public Harddisk(Harddisktype harddisktype, int hdMemorySize, int hdWeight) {
        this.hardDiskType = harddisktype;
        this.hdMemorySize = hdMemorySize;
        this.hdWeight = hdWeight;
    }

    public Harddisk sethdType(Harddisktype harddisktype) {
        return new Harddisk(harddisktype, hdMemorySize, hdWeight);
    }

    public Harddisktype getHdType() {
        return hardDiskType;
    }

    public Harddisk setMemSize(int hdMemorySize) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }

    public int getMemSize() {
        return hdMemorySize;
    }

    public Harddisk setWeight(int hdWeight) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }

    public int getWeight() {
        return hdWeight;
    }



    public Harddisk getHdWeight(int hdWeight) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }

    public String toString () {
        System.out.println("������� ����: " + "\n" + "���: " + getHdType() + "\n" + "�����:"  + getMemSize()
                + "\n" + "���: " + getWeight());
        System.out.println();
        return "";
    }
}
