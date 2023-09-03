public class CargoInformation {

    private final int mass;
    private final String deliveryAdress;
    private final boolean isCoup;
    private final String registrationNumber;
    private final boolean isFragile;
    private final Dimensions dimensions;

    public CargoInformation (boolean isFragile,boolean isCoup, String registrationNumber, String deliveryAdress,
                             int mass, Dimensions dimensions) {
        this.deliveryAdress = deliveryAdress;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
        this.isCoup = isCoup;
        this.mass = mass;
        this.dimensions = dimensions;

    }
    public int getMass() {
        return mass;
    }

    public CargoInformation setMass(int mass) {
        System.out.println(mass);
        return new  CargoInformation (isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public String getDeliveryAdress(){
        return deliveryAdress;
    }

    public CargoInformation setDeliverySdress(String deliveryAdress) {
        return new  CargoInformation (isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public  String getRegistrationNumber() {
        return registrationNumber;
    }

    public CargoInformation setRegistrationNumber(String registrationNumber) {
        return new  CargoInformation (isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public boolean isCoup() {
        return isCoup;
    }

    public CargoInformation setIsCoup(boolean isCoup) {
        return new  CargoInformation (isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public boolean isFragile() {
        return isFragile;
    }

    public CargoInformation setIsFragile(boolean isFragile) {
        return new  CargoInformation (isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public CargoInformation setDimensions( Dimensions dimensions) {
        return new CargoInformation(isFragile, isCoup, registrationNumber, deliveryAdress, mass, dimensions);
    }
    public Dimensions getDimensions (){
        return dimensions;
    }


    public String toString(){
        String screen = "deliveryAdress:" + deliveryAdress + "\n" + "registrationNumber:" + registrationNumber + "\n" +
                "mass = " + mass + "\n" + "isCoup:" + isCoup + "\n" + "isFragile:" + isFragile + "\n" +
                dimensions;
        return screen;

    }
}






