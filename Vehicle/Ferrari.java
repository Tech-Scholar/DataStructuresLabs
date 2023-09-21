public class Ferrari extends Supercar{
    // Sends datafields to superclass
    public Ferrari(String make, double speedIncrease, String owner){
        super("Ferrari", make, speedIncrease, owner);
    }
    // Unique method that prints out victory message
    public void specialDance(){
        System.out.println(String.format("%s drifted to victory!", super.getOwner()));
    }
}