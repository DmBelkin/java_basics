public class Mymonitor {

    private final int diag;
    private static Monitortype monitortype;
    private final int weight;

    public Mymonitor( Monitortype monitortype, int diag, int weight) {
        this.diag = diag;
        this.monitortype = monitortype;
        this.weight = weight;
    }
    public static Monitortype getMonitortype() {
        monitortype = Monitortype.valueOf("IPS");
        return monitortype;
    }
    public int getDiag(){
        return diag;
    }
    public int getWeight() {
        return weight;
    }
    public String print() {
        String print = "���: " + getMonitortype() + "\n" + "���������: " + getDiag() + "'" + "\n" + "���: " + getWeight() + "g";
        System.out.println("�������: ");
        System.out.println(print);
        System.out.println();
        return print;
    }

}
