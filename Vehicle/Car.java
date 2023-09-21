public class Car extends AbstractVehicle{
    // Creates datafields
    private int x;
    private String owner;
    // Fills them up
    public Car(String model, String make, double speedIncrease, String owner){
        super.on = false;
        super.speed = speedIncrease;
        super.type = model + " " + make;
        this.owner = owner;
        this.x = 0;
    }
    // getters and setters
    public void move(){
        this.x += super.speed;
    }
    public int getX(){
        return this.x;
    }
    public String getOwner(){
        return owner;
    }
    // Performs random action if the racer hit an obstacle
    public void hitObstacle(){
        int numOfObstacles = (int)(Math.random() * 10);
        if (numOfObstacles <= 4){
            System.out.println(String.format("%s hit a rock!", owner));
            super.decelerate(10);
        }
        else if (numOfObstacles <= 8){
            System.out.println(String.format("%s hit a boost pad!", owner));
            super.accelerate(20);
        }
        else if (numOfObstacles == 9){
            System.out.println(String.format("%s's engine died", owner));
            super.stop();
        }
    }
    // Default special dance method
    public void specialDance(){
        System.out.println(String.format("%s drove his way to victory", owner));
    }
}