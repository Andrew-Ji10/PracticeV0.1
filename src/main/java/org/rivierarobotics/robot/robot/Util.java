package org.rivierarobotics.robot.robot;

public class Util {
    private static double deadbandval = 0.1;
    public static double ticksToDegrees = 360/4096;
    public static double degreesToTicks = 4096/360;
    public static double ticksToRads = (2 * Math.PI)/4096;
    public static double wheelradius = 0.04;

    public static double deadbandSet(double val){
        if(Math.abs(val) < deadbandval){
            return 0;
        }
        return val;
    }
}
