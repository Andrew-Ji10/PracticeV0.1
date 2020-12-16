package org.rivierarobotics.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.robot.robot.Robot;
import org.rivierarobotics.robot.robot.Util;
import org.rivierarobotics.robot.subsystems.DriveTrain;

public class DriveControl extends CommandBase {
    private final Joystick joyRight;
    private final Joystick joyLeft;
    private final DriveTrain driveTrain;

    public DriveControl(Joystick joyRight, Joystick joyLeft, DriveTrain driveTrain) {
        this.joyLeft = joyLeft;
        this.joyRight = joyRight;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.setPower(Util.deadbandSet(joyLeft.getY()), Util.deadbandSet(joyLeft.getY()));
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
