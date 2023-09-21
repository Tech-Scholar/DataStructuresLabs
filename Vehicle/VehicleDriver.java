public class VehicleDriver {
    public static void main(String[] args) {
        // Instantiates all cars
        Ford a = new Ford("Explorer", 80, "Andrew");
        Honda b = new Honda("Accord", 90, "Noah");
        Lamborghini c = new Lamborghini("911", 130.0, "George");
        Ferrari d = new Ferrari("F40", 140.0, "Arsenii");
        // Races the cars
        race(a, b, 1000);
        race(c, d, 1000);
    }
    
    // Method that races cars
    public static void race(Car racer1, Car racer2, double length) {
        System.out.println(String.format("%s challenged %s to a race!", 
        racer1.getOwner(), racer2.getOwner()));
        // Starts the race
        RaceOfficial official = new RaceOfficial(racer1, racer2, length);
        official.startRace();
        official.createObstacles();
        // Keeps running till one car wins or a tie
        boolean gameOn = true;
        while (gameOn) {
            official.checkHitObstacle();
            racer1.move();
            racer2.move();
            gameOn = official.checkForWinner();
        }
    }
}