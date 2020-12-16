package org.rivierarobotics.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSide {
    private final WPI_TalonSRX front;
    private final WPI_TalonSRX back;

    public DriveSide (int front, int back, boolean invert){
        this.front = new WPI_TalonSRX(front);
        this.back = new WPI_TalonSRX(back);
        this.back.follow(this.front);
        this.front.setInverted(invert);
    }

    public void setPower (double power) {
        front.set(power);
        front.set(power);
    }

}
