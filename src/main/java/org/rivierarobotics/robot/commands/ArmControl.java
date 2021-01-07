package org.rivierarobotics.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.robot.robot.Util;
import org.rivierarobotics.robot.subsystems.Arm;

public class ArmControl extends CommandBase {
    private final Arm arm;
    private final Joystick joystick;

    public ArmControl(Arm arm, Joystick joystick){
        this.arm = arm;
        this.joystick = joystick;
    }

    @Override
    public void execute() {
        arm.setPower(Util.deadbandSet(joystick.getY()));
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
