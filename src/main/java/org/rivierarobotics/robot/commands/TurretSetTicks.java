package org.rivierarobotics.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.robot.subsystems.Turret;

public class TurretSetTicks extends CommandBase {
    private final Turret turret;
    private final double targetTicks;

    public TurretSetTicks(double targetTicks, Turret turret){
        this.turret = turret;
        this.targetTicks = targetTicks;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.setTicksPosition(targetTicks);
    }

    @Override
    public boolean isFinished() {
        return turret.getAbsTickPosition() >= targetTicks;
    }
}
