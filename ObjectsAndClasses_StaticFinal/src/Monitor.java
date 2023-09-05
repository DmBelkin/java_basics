public class Monitor {

    private final Monitortype monitorType;
    private final int diag;
    public final int monitorWeight;

    public Monitor(Monitortype monitortype, int diag, int monitorWeight) {
        this.monitorType = monitortype;
        this.diag = diag;
        this.monitorWeight = monitorWeight;
    }

    public Monitortype getType() {
        return monitorType;
    }

    public int getDiag() {
        return diag;
    }

    public int getWeight() {
        return monitorWeight;
    }

    public String toString() {
        return "Монитор: " + "\n" + "Тип: " + getType() + "\n" + "Диагональ:" + getDiag()
                    + "\n" + "Вес: " + getWeight() + "\n";
    }
}
