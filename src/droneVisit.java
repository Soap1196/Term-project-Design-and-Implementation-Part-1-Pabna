
public interface droneVisit {

    Tello myDrone = new Tello();
    TelloController telloController = myDrone.getController();

    //drone take off
    public void takeoff();

    // scan farm assuming command center is in upper left hand corner    
    public void scanFarm();

    // go to building or room
    public void goToRoom();


}
