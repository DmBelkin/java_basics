

public class Ram {

    private final Ramtype ramType;
    private final int ramMemorySize;
    protected final int ramWeight;

    public Ram(Ramtype ramtype, int ramMemorySize, int ramWeight) {
        this.ramType = ramtype;
        this.ramMemorySize = ramMemorySize;
        this.ramWeight = ramWeight;
    }

    public Ramtype getType() {
        return ramType;
    }

    public int getSize() {
        return  ramMemorySize;
    }

    public int getWeight() {
        return ramWeight;
    }


    public String toString() {
        return "Оперативная память: " + "\n" + "Тип: " + getType() + "\n" + "Объем: " +
                    getSize() + "\n" + "Вес: " + getWeight() + "\n";
    }
}
