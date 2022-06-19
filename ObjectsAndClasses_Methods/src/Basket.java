public class Basket {

    private static int count = 0;
    private String items = "";
    public int totalPrice = 0;
    private int limit;
    private  int price;
    public static int fullPrice;
    public static int fullItems;
    public static int averagePrice;

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
    public int getTotalPrice() {
        return totalPrice;
    }

    public static int getFullPrice() {
        return fullPrice;
    }
    public static  int getFullItems() {
        return fullItems;
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
        totalPrice = totalPrice + price * count;
        Basket.fullPrice = Basket.fullPrice + price * count;
        Basket.fullItems = Basket.fullItems + count;
        Basket.averagePrice = Basket.fullPrice / Basket.fullItems;
        setBasketAveragePrice();
    }
    public static int getAveragePrice() {
        return averagePrice;
    }
    public int setBasketAveragePrice() {
        int basketAveragePrice = totalPrice / count;
        return basketAveragePrice;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print() {
        System.out.println(items);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Стоимость товаров в корзине: " +  getTotalPrice());
            System.out.println("Средняя стоимость товаров в корзине: " + setBasketAveragePrice());

        }
    }
}
