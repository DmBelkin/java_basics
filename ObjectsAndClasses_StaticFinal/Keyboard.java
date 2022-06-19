public class Keyboard {
    private final int keyboardWeight;
    private KeyboardType type;
    private KeyboardLight light;

    public Keyboard( KeyboardType type, KeyboardLight light, int keyboardWeight) {
        this.type = type;
        this.light = light;
        this.keyboardWeight = keyboardWeight;
    }


    public Keyboard setKeyboardWeight(int keyboardWeight){
        return new Keyboard(type, light, keyboardWeight);
    }
    public int getKeyboardWeight() {
        return keyboardWeight;
    }

    public void setLight(KeyboardLight light) {
        this.light = light;
    }
    public KeyboardLight getLight() {
        return light;
    }

    public void setType(KeyboardType type) {
        this.type = type;
    }
    public KeyboardType getType() {
        return  type;
    }

    public String print(String print){
        print = "Клавиатура: " + "\n" + "Подсветка: " + light  + "\n" + "Тип: " + type
                + "\n" + "Вес: " + keyboardWeight;
        return  print;
    }

}
