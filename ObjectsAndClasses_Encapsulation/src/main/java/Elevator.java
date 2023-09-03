public class Elevator {

    private int currentFloor = 1;

    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public void moveUp(int currentFloor) {
        this.currentFloor = (currentFloor < maxFloor) ? currentFloor + 1 : currentFloor;
    }
    public void moveDown(int currentFloor) {
        this.currentFloor = (currentFloor > minFloor) ? currentFloor - 1 : currentFloor;

    }
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Error");
        }
        else if (currentFloor > floor) {
            while (currentFloor != floor) {
                moveDown(currentFloor);
                System.out.println(currentFloor);
            }
        }
        else if (currentFloor < floor) {
            while (currentFloor != floor) {
                moveUp(currentFloor);
                System.out.println(currentFloor);
            }
        }
    }
}

