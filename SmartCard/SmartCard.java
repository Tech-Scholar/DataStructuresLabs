public class SmartCard {
  private boolean onboard;
  private double balance;
  private Station station;
  public SmartCard(double balance){
    this.balance = balance;
    this.station = null;
    this.onboard = false;
  }
  public double getBalance(){
    return balance;
  }
  public boolean getIsBoarded(){
    return onboard;
  }
  public Station getBoardedAt(){
    return station;
  }
  public String getFormattedBalance(){
    return String.format("$%.2f", balance);
  }
  public void board(Station s){
    if (onboard){
      System.out.println("Error: already boarded?!");
    }
    else if (balance < 0.50){
      System.out.println("Insufficient funds to board. Please add more money.");
    }
    else {
        station = s;
        onboard = true;
    }
  }
  public double cost(Station s){
    int start_zone = station.getZone();
    int end_zone = s.getZone();
    double cost = 0.50;
    for (int i = start_zone; i < end_zone; i++){
      cost += 0.75;
    }
    return cost;
  }
  public void exit(Station s){
    if (!onboard){
      System.out.println("Error: Did not board?!");
      return;
    }
    double cost = cost(s);
    if (cost > balance){
      System.out.println("Insufficient funds to exit. Please add more money.");
      return;
    }
    balance -= cost;
    onboard = false;
    System.out.println(String.format("From %s to %s costs $%.2f. SmartCard has $%.2f",station.getName(), s.getName(), cost, balance));
    station = null;
  }
  public void addMoney(double d){
    balance += d;
    System.out.println(String.format("$%.2f added. Your new balance is $%.2f", d, balance));
  }
}

class Station {
  private String name;
  private int zone;
  public Station(){
    this.name = "";
    this.zone = 0;
  }
  public Station(String name, int zone){
    this.name = name;
    this.zone = zone;
  }
  public String getName(){
    return name;
  }
  public int getZone(){
    return zone;
  }
}
