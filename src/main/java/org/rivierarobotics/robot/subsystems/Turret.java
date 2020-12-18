package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.rivierarobotics.robot.robot.Util;

public class Turret extends SubsystemBase {
    private final WPI_TalonSRX turretTalon;
    private final double maxAngle = 45;
    private final double minAngle = -45;
    private final double zeroTicks = 100;

    public Turret(){
        turretTalon = new WPI_TalonSRX(7);
        turretTalon.setNeutralMode(NeutralMode.Brake);

    }

    public void setTickPosition(double ticks){
        if (ticks <= maxAngle * Util.degreesToTicks && ticks >= minAngle * Util.degreesToTicks){
            turretTalon.set(ControlMode.MotionMagic, ticks);
        }
    }

    public double getTickPosition(){
        return turretTalon.getSensorCollection().getPulseWidthPosition();
    }

    public double getAbsTickPosition(){
        return getTickPosition()%4096;
    }

    public double getDegreesPosition(){
        return getTickPosition() * Util.ticksToDegrees;
    }

    public void setPower(double power){
        double fPower = power;
        if (getAbsTickPosition() > (maxAngle * Util.degreesToTicks + zeroTicks) && power > 0){
            fPower = 0;
        } else if (getAbsTickPosition() < ((minAngle + 360)*Util.degreesToTicks + zeroTicks) && power < 0){
            fPower = 0;
        }
        turretTalon.set(ControlMode.PercentOutput, fPower);
    }

    public void setTicksPosition(double targetTicks){
        if(targetTicks % 4096 <= (maxAngle * Util.degreesToTicks + zeroTicks) && targetTicks % 4096 >= (minAngle * Util.degreesToTicks + zeroTicks)){
            turretTalon.set(ControlMode.MotionMagic, targetTicks % 4096);
        }
    }

}
