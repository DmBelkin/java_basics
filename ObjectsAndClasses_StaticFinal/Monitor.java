public class Monitor {

    private Monitortype monitorType;
    private final int diag;
    private final int monitorWeight;

    public Monitor(Monitortype monitortype, int diag, int monitorWeight) {
        this.monitorType = monitortype;
        this.diag = diag;
        this.monitorWeight = monitorWeight;
    }

    public void setMonitorType(Monitortype monitortype) {
    }
    public Monitortype getMonitorType() {
        return monitorType;
    }

    public Monitor setDiag(int diag) {
        return new Monitor(monitorType, diag, monitorWeight);
    }
    public int getDiag() {
        return diag;
    }

    public Monitor setMonitorWeight(int monitorWeight) {
        return new Monitor(monitorType, diag, monitorWeight);
    }
    public int getMonitorWeight() {
        return monitorWeight;
    }

    public String print(String print) {
            print = "Монитор: " + "\n" + "Тип: " + monitorType + "\n" + "Диагональ:" + diag
                    + "\n" + "Вес: " + monitorWeight;
            return print;
    }
}
