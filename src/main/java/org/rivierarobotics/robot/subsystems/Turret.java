package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Turret {
    private final WPI_TalonSRX turretTalon;

    public Turret(){
        turretTalon = new WPI_TalonSRX(7);
    }

    public void setPower(double power){
        turretTalon.set(power);
    }
}
