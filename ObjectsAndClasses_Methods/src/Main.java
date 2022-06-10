

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Молоко", 40, 5);
        basket.print();
        System.out.println();

        Basket basket1 = new Basket();
        basket1.add("Хлеб", 32, 3);
        basket1.add("Лимонад", 124, 2);
        basket1.add("Мясо", 459, 1);
        basket1.add("Цветы", 1280, 1);
        basket1.print();
        System.out.println();

        Basket basket2 = new Basket();
        basket2.add("Печенье", 78, 2);
        basket2.add("Детское питание", 532, 3);
        basket2.add("Салфетки", 46, 1);
        basket2.print();
        System.out.println();

//        Basket basket3 = new Basket("Булочка", 50);
//        basket3.print();
//        System.out.println();

        Session session = new Session();

        System.out.println("Общее количество товаров: " + Basket.getFullItems());
        System.out.println("Общая стоимость товаров: " + Basket.getFullPrice());
        System.out.println("Количество корзин: " + Basket.getCount());
        System.out.println("Средняя цена товаров во всех корзинах: " + Basket.getAveragePrice());

    }
}


