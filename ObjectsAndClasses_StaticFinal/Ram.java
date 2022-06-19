public class Ram {

    private Ramtype ramType;
    private final int ramMemorySize;
    private final int ramWeight;

    public Ram(Ramtype ramtype, int ramMemorySize, int ramWeight) {
        this.ramType = ramtype;
        this.ramMemorySize = ramMemorySize;
        this.ramWeight = ramWeight;
    }

    public void setRamType(Ramtype ramtype) {
        this.ramType = ramtype;
    }
    public Ramtype getRamType() {
        return ramType;
    }
    public Ram setMemorySize(int ramMemorySize) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }
    public int getRamMemorySize() {
        return ramMemorySize;
    }
    public Ram setRamWeight(int ramWeight ) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }
    public int getRamWeight() {
        return ramWeight;
    }

    public String print(String print) {
        print = "Оперативная память: " + "\n" + "Тип: " + ramType + "\n" + "Объем: " +
                ramMemorySize + "\n" + "Вес: " + ramWeight;
        return print;
    }
}
