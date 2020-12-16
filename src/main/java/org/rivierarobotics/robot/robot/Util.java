package org.rivierarobotics.robot.robot;

public class Util {
    private static double deadbandval = 0.1;

    public static double deadbandSet(double val){
        if(Math.abs(val) < deadbandval){
            return 0;
        }
        return val;
    }
}
