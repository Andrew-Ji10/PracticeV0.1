package org.rivierarobotics.robot.subsystems;

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

    }

    public double getTickPosition(){
        return turretTalon.getSensorCollection().getPulseWidthPosition();
    }

    public double getDegreesPosition(){
        return getTickPosition() * Util.ticksToDegrees;
    }

    public void setPower(double power){
        double fPower = power;
        if (getTickPosition() > (maxAngle * Util.degreesToTicks + zeroTicks) && power > 0){
            fPower = 0;
        } else if (getTickPosition() < ((minAngle + 360)*Util.degreesToTicks + zeroTicks) && power < 0){
            fPower = 0;
        }
        turretTalon.set(fPower);
    }
}
