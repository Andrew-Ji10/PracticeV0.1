package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

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
}
