import com.tello.Tello;
import com.tello.connection.impl.TelloController;

public class telloDroneMain implements droneVisit {
    public static void main(String args[]) throws InterruptedException {
        Tello myDrone = new Tello();
        TelloController telloController = myDrone.getController();

        public void takeoff(){
            telloController.takeoff();    
        }
        
        // System.out.println(telloController.getBattery());
        // Thread.sleep(500);

        // scan farm assuming command center is in upper left hand corner
        public void scanFarm(){
            for (int i=0; i<15;i++) {
                telloController.flyForward((short) 610);
                telloController.rotate(270);
                telloController.flyForward((short) 61);
                telloController.rotate(270);
                telloController.flyForward((short) 610);
                telloController.rotate(90);
                telloController.flyForward((short) 61);
                telloController.rotate(90);
                telloController.flyForward((short) 610);
                }

                telloController.rotate(90);
                telloController.flyForward((short) 915);
                telloController.rotate(90);
                telloController.flyForward((short) 610);

                telloController.rotate(360);

                System.out.println("Farm scanned. I am home.");
        }
        

        // go to building or room
        public void goToRoom(){
            telloController.flyForward((short) 610);
            telloController.rotate(180);
            telloController.flyForward((short) 610);
            telloController.rotate(360);

            System.out.println("Buidling Visited. I am home.");
        }
        


        public void land(){
            telloController.land();
            myDrone.shutdownGracefully();
        }
        
    }
}