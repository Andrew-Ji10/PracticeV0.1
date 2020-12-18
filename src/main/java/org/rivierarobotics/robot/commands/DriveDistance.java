package org.rivierarobotics.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.robot.robot.Util;
import org.rivierarobotics.robot.subsystems.DriveTrain;

public class DriveDistance extends CommandBase {
    private final DriveTrain driveTrain;
    private final double distance;
    private final double power;
    private double startTicks;

    public DriveDistance(DriveTrain driveTrain, double distance, double power){
        this.driveTrain = driveTrain;
        this.distance = distance;
        this.power = power;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        startTicks = driveTrain.getLeftSide().getPosition();
    }

    @Override
    public void execute() {
        double direction = Math.signum(distance);
        double directedPower = direction * power;
        driveTrain.setPower(directedPower, directedPower);
    }

    @Override
    public boolean isFinished() {
        return ((driveTrain.getLeftSide().getPosition() - startTicks) * Util.ticksToRads * Util.wheelradius) >= distance;
    }
}
