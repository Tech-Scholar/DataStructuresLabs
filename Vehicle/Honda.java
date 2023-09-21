public class Honda extends RegularCar {
    // Sends datafields to superclass
    public Honda(String make, double speedIncrease, String owner) {
        super("Honda", make, speedIncrease, owner);
    }
    // Unique method that prints out victory message
    public void specialDance() {
        System.out.println(String.format("%s did a wheelie!", super.getOwner()));
    }
}