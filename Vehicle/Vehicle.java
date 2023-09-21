public interface Vehicle {
    // Method to start the vehicle
    void start();

    // Method to stop the vehicle
    void stop();

    // Method to accelerate the vehicle by a given speed (in km/h)
    void accelerate(double speed);

    // Method to decelerate the vehicle by a given speed (in km/h)
    void decelerate(double speed);

    // Method to get the type of vehicle (e.g., "Car", "Bicycle")
    String getVehicleType();
}