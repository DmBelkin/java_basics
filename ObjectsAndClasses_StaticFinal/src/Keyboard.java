public class Keyboard {

    private final int keyboardWeight;
    private final KeyboardType type;
    private final KeyboardLight light;

    public Keyboard( KeyboardType type, KeyboardLight light, int keyboardWeight) {
        this.type = type;
        this.light = light;
        this.keyboardWeight = keyboardWeight;
    }

    public KeyboardType getKeyType() {
        return type;
    }

    public KeyboardLight getKeysLight() {
        return light;
    }


    public int getWeight() {
        return keyboardWeight;
    }

    public String toString (){
        return "Клавиатура: " + "\n" + "Подсветка: " + getKeysLight() + "\n" + "Тип: " + getKeyType()
                + "\n" + "Вес: " + getWeight() + "\n";
    }

}
