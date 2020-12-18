/*
 * This file is part of GradleRIO-Redux-example, licensed under the GNU General Public License (GPLv3).
 *
 * Copyright (c) Riviera Robotics <https://github.com/Team5818>
 * Copyright (c) contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.rivierarobotics.robot.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import org.rivierarobotics.robot.commands.DriveControl;
import org.rivierarobotics.robot.commands.TurretControl;
import org.rivierarobotics.robot.subsystems.DriveTrain;
import org.rivierarobotics.robot.subsystems.Turret;

public class Robot extends TimedRobot {

    private final DriveTrain driveTrain;
    private final Joystick rightJoy;
    private final Joystick leftJoy;
    private final Joystick turretJoy;
    private final Turret turret;

    public Robot () {
        this.driveTrain = new DriveTrain();
        this.turret = new Turret();
        this.rightJoy = new Joystick(0);
        this.leftJoy = new Joystick(1);
        this.turretJoy = new Joystick(2);
    }


    @Override
    public void teleopInit() {
        new DriveControl(rightJoy, leftJoy, driveTrain).schedule();
        new TurretControl(turret, turretJoy).schedule();
    }

    @Override
    public void teleopPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
