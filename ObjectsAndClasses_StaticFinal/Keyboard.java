
public class Keyboard {

    private  KeyboardLight light;
    private  KeyboardType type;
    private final int weight;

    public Keyboard (KeyboardLight light, KeyboardType type, int weight) {
        this.light = light;
        this.type = type;
        this.weight = weight;
    }

    public static KeyboardLight getLight(KeyboardLight light) {
        light = KeyboardLight.valueOf("PHIOLENT");
         return light;
    }

    public static KeyboardType getType(KeyboardType type) {
        type = KeyboardType.valueOf("ERGONOMIC");
        return type;
    }
    public int getWeight(int weight) {
        return weight;
    }

    public String print() {
        System.out.println("Клавиатура: ");
        String print = "Подсветка: " + getLight(light) + "\n" + "Тип: " + getType(type) + "\n" + "Вес: " + getWeight(weight) + "g";
        System.out.println(print);
        System.out.println();
        return print;
    }
}
/**
 * геттеры и сеттеры на переменные класса + логика наличия/отсутствия подсветки
 */
