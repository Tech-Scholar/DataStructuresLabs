public abstract class AbstractVehicle implements Vehicle{
    // Datafileds
    boolean on;
    double speed;
    String type;
    // Getters and setters
    public void start(){
        this.on = true;   
    }
    public void stop(){
        this.on = false;
        this.speed = 0.0; 
    }
    public void accelerate(double speed){
        if (this.on){
          this.speed += speed;  
        }
    }
    public void decelerate(double speed){
        if (this.on){
           this.speed -= speed; 
        }
    }
    public String getVehicleType(){
        return type;
    }
}
