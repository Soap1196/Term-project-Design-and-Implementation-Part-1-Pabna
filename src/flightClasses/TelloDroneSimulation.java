package flightClasses;

import java.io.IOException;

public interface TelloDroneSimulation {
    void scan() throws IOException, InterruptedException;
    void goToItem(double x, double y) throws IOException, InterruptedException;
    double calculateDroneRotation(double xStart, double yStart, double xEnd, double yEnd) throws IOException, InterruptedException;
    double calculateDroneDistance(double xStart, double yStart, double xEnd, double yEnd) throws IOException, InterruptedException;
    void activateDrone() throws IOException, InterruptedException;
    void establishDrone() throws IOException, InterruptedException;
    void moveDrone(double xStart, double yStart, double xEnd, double yEnd) throws IOException, InterruptedException;
    void landDrone() throws IOException, InterruptedException;
    void scanFarm(double xStart, double yStart, double xEnd, double yEnd) throws IOException, InterruptedException;
}
