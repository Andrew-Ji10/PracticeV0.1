package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.rivierarobotics.robot.robot.Util;

public class Arm {
    private final WPI_TalonSRX armTalon;
    private final double zeroTicks = 100;
    private final double maxTicks = 4096/4 + zeroTicks;
    private final double minTicks = -4096/4 + zeroTicks;


    public Arm(){
        armTalon = new WPI_TalonSRX(8);
        armTalon.setNeutralMode(NeutralMode.Brake);
    }

    public double getAbsTickPosition(){
        return armTalon.getSensorCollection().getPulseWidthPosition();
    }

    public double getRelativeRads(){
        return (getAbsTickPosition() - 100) * Util.ticksToRads;
    }

    public void setPower(double power){
        double fPower = power;
        if (getAbsTickPosition() > maxTicks && power > 0){
            fPower = 0;
        } else if (getAbsTickPosition() < minTicks  && power < 0){
            fPower = 0;
        }
        if (fPower > 0){
            fPower = ((Math.cos(getRelativeRads())/2) + 1/2) * fPower;
        } else if (fPower < 0) {
            fPower = (-(Math.cos(getRelativeRads())/2) + 1) * fPower;
        }
        armTalon.set(ControlMode.PercentOutput, fPower);
    }
}
