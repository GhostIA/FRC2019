/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;;

/**
 * Add your docs here.
 */
public class Piston extends Subsystem {
  private DoubleSolenoid  piston;
  private int port1, port2;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Piston(int port1, int port2){
    this.port1 = port1;
    this.port2 = port2;
    piston = new DoubleSolenoid(port1, port2);
  }
  public DoubleSolenoid.Value isForward(){
    return piston.get();
  }

  public void forward(){
    piston.set(Value.kForward);
  }

  public void reverse() {
   
     piston.set(Value.kReverse);
  }

  public void off() {
   // piston.set(Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
