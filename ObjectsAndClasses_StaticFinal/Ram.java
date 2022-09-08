

public class Ram {

    private final Ramtype ramType;
    private final int ramMemorySize;
    protected final int ramWeight;

    public Ram(Ramtype ramtype, int ramMemorySize, int ramWeight) {
        this.ramType = ramtype;
        this.ramMemorySize = ramMemorySize;
        this.ramWeight = ramWeight;
    }

    public Ram setType(Ramtype type) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }

    public Ramtype getType() {
        return ramType;
    }

    public Ram setSize(int ramMemorySize) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }

    public int getSize() {
        return  ramMemorySize;
    }

    public Ram setWeight(int ramWeight) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }

    public int getWeight() {
        return ramWeight;
    }

    public Ram setRamWeight(int ramWeight ) {
        return new Ram(ramType, ramMemorySize, ramWeight);
    }

    public String toString() {
        System.out.println("Оперативная память: " + "\n" + "Тип: " + getType() + "\n" + "Объем: " +
                    getSize() + "\n" + "Вес: " + getWeight());
        System.out.println();
        return "";
    }
}
