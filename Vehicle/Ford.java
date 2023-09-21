public class Ford extends RegularCar {
    // Sends datafields to superclass
    public Ford(String make, double speedIncrease, String owner) {
        super("Ford", make, speedIncrease, owner);
    }
    // Unique method that prints out victory message
    public void specialDance() {
        System.out.println(String.format("%s did a donut!", super.getOwner()));
    }
}