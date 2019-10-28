/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class ShootTrigger extends JoystickButton{
    
    private int buttonNum;
    private GenericHID joy;
    
    public ShootTrigger(GenericHID joystick, int buttonNumber){
        super(joystick, buttonNumber);
        this.buttonNum = buttonNumber;
		this.joy = joystick;
    }

    @Override
	public boolean get()
	{
        return joy.getRawButton(this.buttonNum) && OI.driverJoy.getSpeedAxis() < 0.01 && OI.driverJoy.getSpeedAxis() > -0.01;
	}
}

