/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.Robot;
import poroslib.commands.ActivateMechSys;
import poroslib.commands.auto.TimedMechDrive;
import poroslib.commands.auto.TimedMechSys;
import poroslib.commands.auto.Timeout;

public class Shoot extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Shoot() {
//Activate wheels
//close piston
//delay
//open same piston
//delay
//stop wheels
//delay
  addParallel(new LockDriveTrain());
  addParallel(new ActivateMechSys(Robot.shooter, -0.5));
  addSequential(new Timeout(1));
  addSequential(new OpenReload());
  addSequential(new ToggleLiveSolenoid());
  addSequential(new Timeout(1.2));
  addSequential(new CloseReload());
  addSequential(new Timeout(1)); 
  addSequential(new TimedMechSys(Robot.shooter, 0, 0));
  addSequential(new ReleaseDriveTrain());
  addSequential(new Timeout(0.5)); 
  }
}

