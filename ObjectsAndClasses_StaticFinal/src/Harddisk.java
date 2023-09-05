

public class Harddisk {

    private final Harddisktype hardDiskType;
    private final int hdMemorySize;
    protected final int hdWeight;

    public Harddisk(Harddisktype harddisktype, int hdMemorySize, int hdWeight) {
        this.hardDiskType = harddisktype;
        this.hdMemorySize = hdMemorySize;
        this.hdWeight = hdWeight;
    }

    public Harddisktype getHdType() {
        return hardDiskType;
    }

    public int getMemSize() {
        return hdMemorySize;
    }

    public int getWeight() {
        return hdWeight;
    }

    public Harddisk getHdWeight(int hdWeight) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }

    public String toString () {
        return "Жесткий диск: " + "\n" + "Тип: " + getHdType() + "\n" + "Объем:"  + getMemSize()
                + "\n" + "Вес: " + getWeight() + "\n";
    }
}
