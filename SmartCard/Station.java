public class Station {
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
