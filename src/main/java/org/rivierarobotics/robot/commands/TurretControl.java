package org.rivierarobotics.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.robot.robot.Util;
import org.rivierarobotics.robot.subsystems.Turret;

public class TurretControl extends CommandBase {
    private final Turret turret;
    private final Joystick joystick;

    public TurretControl(Turret turret, Joystick joystick){
        this.turret = turret;
        this.joystick = joystick;
    }

    @Override
    public void execute() {
        turret.setPower(Util.deadbandSet(joystick.getX()));
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
