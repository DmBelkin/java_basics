import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dimensions object = new Dimensions(12,23,56);
        object.Volume();
        CargoInformation cargoInformation = new CargoInformation(true,
                false, "123AER65",
                "madisson avenue",12, new Dimensions(1, 54, 33));
        cargoInformation.print();

        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("¬ведите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }
}

