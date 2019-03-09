/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * Add your docs here.
 */
public class LimitSwitches extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DigitalInput limitSwitch1, limitSwitch2;
  public LimitSwitches(){
    limitSwitch1 = new DigitalInput(0);
    limitSwitch2 = new DigitalInput(1);

  }
  public boolean isSwitch1Set(){
    boolean switchSet = limitSwitch1.get();
    return switchSet;
  }
  public boolean isSwitch2Set(){
    boolean switchSet = limitSwitch2.get();
    return switchSet;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
