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
        boolean turnLeft = true;
        //fly to the midpoint
        System.out.println("I'm running!");
        drone.activateSDK();
        drone.hoverInPlace(2);
        drone.takeoff();
        int distancex = Math.abs((int) ((midX - droneHomex) / 25) * 30);
        int distancey = Math.abs((int) ((midY - droneHomey) / 25) * 30);
        //determine angle to turn
        int turnAngle = (int) angle(distancex, distancey);
        int spinAngle = 360 + 180;

        //determine direction to turn
        if(midX > droneHomex){
            drone.turnCCW(turnAngle); //left
            turnLeft = true;
        }else if(midX < droneHomex){
            drone.turnCW(turnAngle); //right
            turnLeft = false;
        }
        //determine distance to fly
        int distance = hypo(distancex, distancey);
        drone.flyForward(distance);

        drone.turnCCW(spinAngle); //spin

        //return to home position
        drone.flyForward(distance);
        spinAngle = 180 - turnAngle;
        if(turnLeft){
            drone.turnCCW(spinAngle); //left
        } else{
            drone.turnCW(spinAngle); //right
        }
        //land and end flight
        drone.land();
        drone.end();
    }

    //calculate the hypotenuse of the triangle
    public int hypo(int x, int y){
        int hypotenuse = (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return hypotenuse;
    }

    //determine angle to turn drone using law of sines
    public double angle(int x, int y){
        double angle = Math.asin(x/hypo(x,y));
        return angle;
    }
    
}
