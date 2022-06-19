public class Harddisk {

    private Harddisktype hardDiskType;
    private final int hdMemorySize;
    private final int hdWeight;

    public Harddisk(Harddisktype harddisktype, int hdMemorySize, int hdWeight) {
        this.hardDiskType = harddisktype;
        this.hdMemorySize = hdMemorySize;
        this.hdWeight = hdWeight;
    }
    public void setHardDiskType(Harddisktype harddisktype) {
    }
    public Harddisktype getHardDiskType() {
        return hardDiskType;
    }
    public Harddisk setHdMemorySize(int hdMemorySize) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }
    public int getHdMemorySize() {
        return  hdMemorySize;
    }
    public Harddisk setHdWeight(int hdWeight) {
        return new Harddisk(hardDiskType, hdMemorySize, hdWeight);
    }
    public int getHdWeight() {
        return hdWeight;
    }
    public String print(String print) {
        print = "Жесткий диск: " + "\n" + "Тип: " + hardDiskType + "\n" + "Объем:"  + hdMemorySize
                + "\n" + "Вес: " + hdWeight;
        return print;
    }
}
