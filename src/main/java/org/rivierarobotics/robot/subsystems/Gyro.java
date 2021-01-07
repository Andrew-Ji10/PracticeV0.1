package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import org.opencv.core.Mat;

public class Gyro {
    private final PigeonIMU gyro;

    public Gyro (int id){
        this.gyro = new PigeonIMU(id);
    }

    private double[] getYPR(){
        double[] ypr = new double[3];
        gyro.getYawPitchRoll(ypr);
        return ypr;
    }

    public double getYaw(){
        return Math.toRadians(getYPR()[0]);
    }

    public double getPitch(){ return  Math.toRadians(getYPR()[1]);}

    public double getRoll(){ return Math.toRadians(getYPR()[2]);}
}
