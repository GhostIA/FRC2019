/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;;

/**
 * Add your docs here.
 */
public class Piston extends Subsystem {
  private Solenoid  piston;
  private int port;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Piston(int port){
    this.port = port;
    piston = new Solenoid(port);
  }
  public boolean isOn(){
    return piston.get();
  }

  public void on(){
    if (piston.get() == false) {
     piston.set(true);
    }
  }

  public void off() {
    piston.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
