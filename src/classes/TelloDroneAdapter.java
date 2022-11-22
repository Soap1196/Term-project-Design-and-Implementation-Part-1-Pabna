package classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import DroneSDK.jdrone.control.physical.tello.TelloDrone;

public class TelloDroneAdapter implements TelloDroneSimulation{
    private TelloDrone drone;
    private Double droneHomex = 400.0;
    private Double droneHomey = 50.0;

    public TelloDroneAdapter() throws SocketException, UnknownHostException, FileNotFoundException {
        drone = new TelloDrone();
    }



    @Override
    public void scan() throws IOException, InterruptedException {
        //distance from home to 0,0
        drone.activateSDK();
		drone.hoverInPlace(2);
		drone.takeoff();
		drone.turnCW(90); //right
        int distancex = (350 / 25) * 30; //go to the corner
        drone.flyForward(distancex);
        drone.turnCCW(90); //turn left

        for(int i = 0; i < 5; i++){
            int distancey = (500 / 25) * 30; //go down
            drone.flyForward(distancey);
            drone.turnCCW(90); //turn left
            distancex = (80/25) * 30; //move to next position
            drone.flyForward(distancex);
            drone.turnCCW(90); //turn left
            distancey = (500 / 25) * 30; //go up
            drone.flyForward(distancey);
            drone.turnCW(90); //turn right
            distancex = (80/25) * 30; //move to next position
            drone.flyForward(distancex);
            drone.turnCW(90); //turn right
        }
        //go back to home position
        drone.turnCW(90); //turn right
        distancex = (350 / 25) * 30; //go back Home
        drone.flyForward(distancex);
        drone.turnCCW(90); //turn left
        drone.land();
        drone.end();
        
    }

    @Override
    public void goToItem(double x, double y) throws IOException, InterruptedException {
        //calculate the midpoint of x and y
        double midX = x;
        double midY = y;
        //fly to the midpoint
        System.out.println("I'm running!");
        drone.activateSDK();
        drone.hoverInPlace(2);
        drone.takeoff();
        if(midX > droneHomex){
            drone.turnCCW(90); // left
            int distancex = (int) ((midX - droneHomex)/25) * 30;
            drone.flyForward(distancex);
            if(midY > droneHomey){
                drone.turnCW(90); // right
                int distancey = (int) ((midY - droneHomey)/25) * 30;
                drone.flyForward(distancey);
                drone.turnCCW(360); // left
                //make the drone return home
                drone.flyBackward(distancey);
                drone.flyRight(distancex);
            }
            else{
                drone.turnCW(90); // left
                int distancey = (int) ((droneHomey - midY)/25) * 30;
                drone.flyForward(distancey);
                drone.turnCW(180); // right
                drone.turnCCW(360); // left
                //make the drone return home
                drone.flyForward(distancey);
                drone.flyRight(distancex);
            }
        }
        else{
            drone.turnCW(90); // right
            double temp = (droneHomex - midX);
            int distancex = (int) (temp/25) * 30;
            System.out.println(distancex);
            drone.flyForward(distancex);
            if(midY > droneHomey){
                drone.turnCCW(90); // left
                double temp2 = (midY - droneHomey);
                int distancey = (int) (temp2/25) * 30;
                System.out.println(distancey);
                drone.flyForward(distancey);
                drone.turnCCW(360); // left
                //make the drone return home
                drone.flyBackward(distancey);
                drone.flyLeft(distancex);
            }
            else{
                drone.turnCW(90); // right
                int distancey = (int) ((droneHomey - midY)/25) * 30;
                drone.flyForward(distancey);
                drone.turnCW(180); // right
                drone.turnCCW(360); // left
                //make the drone return home
                drone.flyForward(distancey);
                drone.flyLeft(distancex);
            }
        }
        drone.land();
        drone.end();
    }

    
}
