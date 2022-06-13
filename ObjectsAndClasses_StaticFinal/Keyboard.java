
public class Keyboard {

    public static KeyboardLight light;
    public static KeyboardType type;
    private final int weight;

    public Keyboard(KeyboardLight light, KeyboardType type, int weight) {
        this.light = light;
        this.type = type;
        this.weight = weight;

    }

    public static KeyboardLight getLight() {
        return light;
    }

    public static KeyboardType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String print() {
        System.out.println("����������: ");
        String print = "���������: " + getLight() + "\n" + "���: " + getType() + "\n" + "���: " + getWeight() + "g";
        System.out.println(print);
        System.out.println();
        return print;
    }
}
/**
 * ������� � ������� �� ���������� ������ + ������ �������/���������� ���������
 */
