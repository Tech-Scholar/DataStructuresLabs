public class Supercar extends Car{
    // Sends datafields to superclass
    public Supercar(String type, String make, double speedIncrease, String owner){
        super(type, make, speedIncrease, owner);
    }
    // Unique method between supercar vs normal car
    public void victoryMessage(){
        System.out.println("Once again, supercars win again.");
    }
}