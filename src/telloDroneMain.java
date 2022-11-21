import flightClasses.*;

import java.io.IOException;

//Code here was taken off of the internet to test intial drone functionality and is not part of our project
//Was just used to test drone connection and function

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
