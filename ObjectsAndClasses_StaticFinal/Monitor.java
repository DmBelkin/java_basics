public class Monitor {

    private final Monitortype monitorType;
    private final int diag;
    public final int monitorWeight;

    public Monitor(Monitortype monitortype, int diag, int monitorWeight) {
        this.monitorType = monitortype;
        this.diag = diag;
        this.monitorWeight = monitorWeight;
    }

    public Monitor setType(Monitortype type) {
        return new Monitor(monitorType, diag, monitorWeight);
    }

    public Monitortype getType() {
        return monitorType;
    }

    public Monitor setDiag(int diag) {
        return new Monitor(monitorType, diag, monitorWeight);
    }

    public int getDiag() {
        return diag;
    }

    public Monitor setWeight(int monitorWeight) {
        return new Monitor(monitorType, diag, monitorWeight);
    }

    public int getWeight() {
        return monitorWeight;
    }

    public Monitor getMonitorWeight(int monitorWeight) {
        return new Monitor(monitorType, diag, monitorWeight);
    }

    public String toString() {
        System.out.println("Монитор: " + "\n" + "Тип: " + getType() + "\n" + "Диагональ:" + getDiag()
                    + "\n" + "Вес: " + getWeight());
        System.out.println();
            return "";
    }
}
