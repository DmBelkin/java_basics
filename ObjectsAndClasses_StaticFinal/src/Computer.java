

public class Computer {

    private  String vendor;

    private  String name;
    //Клавиатура
    private Keyboard keyboard;
    //оперативная память
    private  Ram ram;
    //монитор
    private  Monitor monitor;
    //жесткий диск
    private  Harddisk harddisk;
    //процессор
    private  Processor processor;

    private static int totalWeight;

    public Computer(String vendor, String name, Keyboard keyboard, Ram ram, Monitor monitor, Harddisk harddisk,
                    Processor processor) {
        this.vendor = vendor;
        this.name = name;
        this.keyboard = keyboard;
        this.ram = ram;
        this.monitor = monitor;
        this.harddisk = harddisk;
        this.processor = processor;
        totalWeightCalculate();
    }

    public Computer getVendor(String vendor) {
        this.vendor = vendor;
        return new Computer(vendor, name, keyboard, ram,
                monitor, harddisk, processor);
    }

    public Computer setKeys(Keyboard keyboard) {
        this.keyboard = keyboard;
        return new Computer(vendor, name, keyboard, ram,
                monitor, harddisk, processor);
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Computer getName(String name) {
        this.name = name;
        return new Computer(vendor, name, keyboard, ram,
                monitor, harddisk, processor);
    }

    public Computer setRam(Ram ram) {
        this.ram = ram;
        return new Computer(vendor, name, keyboard, ram, monitor, harddisk, processor);
    }

    public Ram getRam() {
        return ram;
    }

    public Computer setMonitor (Monitor monitor) {
        this.monitor = monitor;
        return new Computer(vendor, name, keyboard, ram, monitor, harddisk, processor);
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Computer setProcessor(Processor processor) {
        this.processor = processor;
        return new Computer(vendor, name, keyboard, ram, monitor, harddisk, processor);
    }

    public Processor getProcessor() {
        return processor;
    }

    public void totalWeightCalculate() {
        Computer.totalWeight = monitor.getWeight() + harddisk.getWeight() +
                processor.getCpuWeight() + ram.getWeight() + keyboard.getWeight();
    }

    public Computer setHd(Harddisk harddisk) {
        this.harddisk = harddisk;
        return new Computer(vendor, name, keyboard, ram, monitor, harddisk, processor);
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    public String toString() {
        return "Ваша конфигурация : " + "\n" + "Производитель: " + vendor + "\n" +
                "Серия: " + name + "\n\n" +
        processor + "\n" +
        harddisk + "\n" +
        ram + "\n" +
        monitor + "\n" +
        keyboard + "\n" +
                "общий вес: " + totalWeight +
                "\n";

    }
}
