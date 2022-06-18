public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private  int price;
    private static int fullPrice = 0;
    private static int fullItems = 0;
    private static double averagePrice = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }
    public Basket(int limit) {
        this();
        this.limit = limit;
    }
    public Basket(String items, int price) {
        this();
        this.items = this.items + items;
        this.price = price;
    }
    public static int getCount() {
        return count;
    }
    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static int getFullPrice() {
        return fullPrice;
    }
    public static  int getFullItems() {
        return fullItems;
    }
    public static void setFullItems (int fullItems) {
        Basket.fullItems = Basket.fullItems + count;
    }
    public void add(String name, int price) {
        add(name, price, count);
    }
    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + "-" + count + "шт.  " + price;
        totalPrice = totalPrice + count * price;
        setFullItems(fullItems);
        Basket.fullPrice = Basket.fullPrice + price  * count;
        double basketAveragePrice = totalPrice / this.count;
        setAveragePrice(averagePrice);
        /**
         * Доработка по замечаниям преподавателя
         */

        System.out.println("Средняя стоимость товаров: " + basketAveragePrice);
        System.out.println();
    }
    public void clear() {
        items = "";
        totalPrice = 0;
    }
    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public static double getAveragePrice() {
        return averagePrice;
    }
    public static void setAveragePrice(double averagePrice) {
        Basket.averagePrice = Basket.fullPrice / Basket.fullItems;
    }
    public void print() {
        System.out.println(items);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Стоимость товаров в корзине: " +  getTotalPrice());

        }
    }
}
