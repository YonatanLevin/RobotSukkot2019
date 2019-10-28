/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.CloseLeftSolenoid;
import frc.robot.commands.CloseRightSolenoid;
import frc.robot.commands.OpenLeftSolenoid;
import frc.robot.commands.OpenRightSolenoid;
import frc.robot.commands.Shoot;
import frc.robot.triggers.ShootTrigger;
import poroslib.commands.ActivateMechSys;
import poroslib.triggers.SmartJoystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private int kShoot = 1;
  private int kSpinShooter = 2;
  private int kOpenLeftSolenoid = 5;
  private int kCloseLeftSolenoid = 3;
  private int kOpenRightSolenoid = 6;
  private int kCloseRightSolenoid = 4;



  public static SmartJoystick driverJoy;
  public static ShootTrigger bShoot;
  public static JoystickButton bSpinShooter;

  public static JoystickButton bOpenLeftSolenoid;
  public static JoystickButton bCloseLeftSolenoid;
  public static JoystickButton bOpenRightSolenoid;
  public static JoystickButton bCloseRightSolenoid;

  public OI()
  {
    driverJoy = new SmartJoystick(RobotMap.kDriverJoyPort);
    driverJoy.setSpeedAxis(1);
    driverJoy.setRotateAxis(2);
    driverJoy.setSlider(3, 0, 0.5, 1, -1);

    
    bShoot = new ShootTrigger(OI.driverJoy, kShoot);
    bSpinShooter = new JoystickButton(OI.driverJoy, kSpinShooter);
    bOpenLeftSolenoid = new JoystickButton(OI.driverJoy, kOpenLeftSolenoid);
    bCloseLeftSolenoid = new JoystickButton(OI.driverJoy, kCloseLeftSolenoid);
    bOpenRightSolenoid = new JoystickButton(OI.driverJoy, kOpenRightSolenoid);
    bCloseRightSolenoid = new JoystickButton(OI.driverJoy, kCloseRightSolenoid);
    //this.bShoot.whenActive(new ActivateShooter());
    bShoot.whenPressed(new Shoot());
    bSpinShooter.whileHeld(new ActivateMechSys(Robot.shooter, -0.8));

    bOpenLeftSolenoid.whenPressed(new OpenLeftSolenoid());
    bCloseLeftSolenoid.whenPressed(new CloseLeftSolenoid());
    bOpenRightSolenoid.whileHeld(new OpenRightSolenoid());
    bCloseRightSolenoid.whileHeld(new CloseRightSolenoid());
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
