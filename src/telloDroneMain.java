import flightClasses.*;

import java.io.IOException;

public class telloDroneMain {
    private static void flight() throws InterruptedException, IOException {
		TelloDrone tello = new TelloDrone();
		tello.activateSDK();
		tello.streamOn();
		tello.hoverInPlace(10);
		tello.takeoff();
		tello.flyForward(100);
		tello.turnCCW(180);
		
		tello.flyForward(100);
		
		tello.turnCW(180);
		tello.land();
		tello.streamOff();
		tello.end();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		flight();
		System.exit(0);
	}

}
