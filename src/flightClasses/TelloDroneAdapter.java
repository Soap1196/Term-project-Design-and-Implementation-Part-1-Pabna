package flightClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TelloDroneAdapter implements TelloDroneSimulation{
    private TelloDrone drone;
    private Double droneHomex = 400.0;
    private Double droneHomey = 50.0;

    public TelloDroneAdapter() throws SocketException, UnknownHostException, FileNotFoundException {
        drone = new TelloDrone();
    }

    @Override
    public void scan() throws IOException, InterruptedException {
        drone.activateSDK();
		drone.hoverInPlace(5);
		drone.takeoff();
		drone.turnCCW(180);
		drone.turnCW(180);
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
    }
        

    @Override
    public double calculateDroneRotation(double xStart, double yStart, double xEnd, double yEnd) throws IOException, InterruptedException {
            double rotationDegrees = (double) Math.toDegrees(Math.atan2(yEnd - yStart, xEnd - xStart));
        
            if(rotationDegrees < 0){
                rotationDegrees += 360;
            }
            System.out.println(rotationDegrees);
            return rotationDegrees;
        }

    @Override
    public double calculateDroneDistance(double xStart, double yStart, double xEnd, double yEnd)throws IOException, InterruptedException {

        return Math.sqrt((yEnd - yStart) * (yEnd - yStart) + (xEnd - xStart) * (xEnd - xStart));
        }

    @Override
    public void activateDrone() throws IOException, InterruptedException {
        drone.activateSDK();
        drone.hoverInPlace(5);
		drone.takeoff();
    }
        

    @Override
    public void moveDrone(double xStart, double yStart, double xEnd, double yEnd)throws IOException, InterruptedException {
        double Rotate = calculateDroneRotation(xStart, yStart, xEnd, yEnd);
        int RotateInt = (int)Rotate;
        double Distance = calculateDroneDistance(xStart, yStart, xEnd, yEnd);
        int DistanceInt = ((int)Distance/3);
		drone.turnCW(RotateInt);
        drone.flyForward(DistanceInt);
        
    }

    @Override
    public void landDrone() throws IOException, InterruptedException {
        drone.land();
        drone.end();
    }

    @Override
    public void establishDrone() throws IOException, InterruptedException {
        drone.turnCCW(360);
        drone.hoverInPlace(5);
        
    }

        
}


    

    
