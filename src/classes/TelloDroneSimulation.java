package classes;

import java.io.IOException;

public interface TelloDroneSimulation {
    void scan() throws IOException, InterruptedException;
    void goToItem(double x, double y) throws IOException, InterruptedException;

}
