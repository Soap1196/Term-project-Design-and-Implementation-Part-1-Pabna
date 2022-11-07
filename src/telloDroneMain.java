import com.tello.Tello;
import com.tello.connection.impl.TelloController;

public class telloDroneMain {
    public static void main(String args[]) throws InterruptedException {
        Tello myDrone = new Tello();
        TelloController telloController = myDrone.getController();

        telloController.takeoff();
        System.out.println(telloController.getBattery());
        Thread.sleep(500);
        
        telloController.land();
        myDrone.shutdownGracefully();
    }
}