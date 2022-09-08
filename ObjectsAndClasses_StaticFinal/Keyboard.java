public class Keyboard {
    private final int keyboardWeight;
    private final KeyboardType type;
    private final KeyboardLight light;

    public Keyboard( KeyboardType type, KeyboardLight light, int keyboardWeight) {
        this.type = type;
        this.light = light;
        this.keyboardWeight = keyboardWeight;
    }

    public Keyboard setKeyType(KeyboardType type) {
        return new Keyboard(type, light, keyboardWeight);
    }

    public KeyboardType getKeyType() {
        return type;
    }

    public Keyboard setKeysLight(KeyboardLight light) {
        return new Keyboard(type, light, keyboardWeight);
    }

    public KeyboardLight getKeysLight() {
        return light;
    }

    public Keyboard setWeight(int keyboardWeight) {
        return new Keyboard(type, light, keyboardWeight);
    }

    public int getWeight() {
        return keyboardWeight;
    }

    public String toString (){
        System.out.println("Клавиатура: " + "\n" + "Подсветка: " + getKeysLight() + "\n" + "Тип: " + getKeyType()
                + "\n" + "Вес: " + getWeight());
        System.out.println();
        return  "";
    }

}
