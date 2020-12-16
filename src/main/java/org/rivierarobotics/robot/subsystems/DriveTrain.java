package org.rivierarobotics.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final DriveSide left;
    private final DriveSide right;

    public DriveTrain(){
        this.left = new DriveSide(2,4, false);
        this.right = new DriveSide(1,3,true);
    }

    public void setPower(double l, double r) {
        left.setPower(l);
        right.setPower(r);
    }
}
