import java.util.ArrayList;
public class RaceOfficial {
    // Creates datafields
    private Car racer1, racer2;
    private double length;
    ArrayList<Double> obs;    
    // Assigns values
    public RaceOfficial(Car racer1, Car racer2, double length){
        this.racer1 = racer1;
        this.racer2 = racer2;
        this.length = length;
        this.obs = new ArrayList<Double>();
    }
    // Checks for a race winner
    public boolean checkForWinner(){
        if (racer1.getX() >= length && racer2.getX() >= length || 
            racer1.speed == 0 && racer2.speed == 0){
            System.out.println(String.format("%s and %s tied!", racer1.getOwner(), racer2.getOwner()));
            return false;
        }
        else if (racer1.getX() >= length && racer2.getX() < length){
            System.out.println(String.format("%s won!", racer1.getOwner()));
            racer1.specialDance();
            return false;
        }
        else if (racer2.getX() >= length && racer1.getX() < length){
            System.out.println(String.format("%s won!", racer2.getOwner()));
            racer2.specialDance();
            return false;
        }    
        return true;
    }
    // Checks if a racer hits an obstacle, and if they do, does an action
    public void checkHitObstacle() {
        for (int x = 0; x < obs.size(); x++) {
            if (racer1.getX() > obs.get(x)) {
                racer1.hitObstacle();
                obs.remove(x);
            }
            else if (racer2.getX() > obs.get(x)) {
                racer2.hitObstacle();
                obs.remove(x);
            }
        }
    }
    // Starts the race
    public void startRace(){
        try {
            Thread.sleep(1000);
            System.out.print("Starting race in: ");  
            for (int i = 3; i > 0; i--){
                Thread.sleep(1000);
                System.out.print(i + " ");  
            }
            Thread.sleep(1000);
            System.out.println("GO!");
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    // Creates obstacles for the racers
    public void createObstacles() {
        int numOfObstacles = (int)(Math.random() * 10 + 1);
        for (int i = 0; i <= numOfObstacles; i++) {
            obs.add(i * (length / numOfObstacles));
        }
    }
}