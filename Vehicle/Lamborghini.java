public class Lamborghini extends Supercar{
    // Sends datafields to superclass
    public Lamborghini(String make, double speedIncrease, String owner){
        super("Lamborgini", make, speedIncrease, owner);
    }
    // Unique method that prints out victory message
    public void specialDance(){
        System.out.println(String.format("%s honked the horn!", super.getOwner()));
    }
}