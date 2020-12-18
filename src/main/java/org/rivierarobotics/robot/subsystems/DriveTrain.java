package org.rivierarobotics.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final DriveSide leftSide;
    private final DriveSide rightSide;

    public DriveTrain(){
        this.leftSide = new DriveSide(2,4, false);
        this.rightSide = new DriveSide(1,3,true);
    }

    public void setPower(double l, double r) {
        leftSide.setPower(l);
        rightSide.setPower(r);
    }

    public DriveSide getLeftSide(){
        return leftSide;
    }

    public DriveSide getRightSide(){
        return rightSide;
    }
}
