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

  public static enum Direction {
    forward, reverse, off
  };

  public Piston(int port){
    this.port = port;
    piston = new Solenoid(port);
  }
  public boolean get(){
    return piston.get();
  }

  public void turnPiston(boolean on){
    if (piston.get() == on) {
      return;
    }

    System.out.println(" turned piston " + port);
    piston.set(on);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
