/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class ArmSubsystem extends Subsystem {
  private WPI_TalonSRX motorOne, motorTwo, motorThree;
  private final double SPEED = 0.5;
  public ArmSubsystem(){
    motorOne = new WPI_TalonSRX(4);
    motorTwo = new WPI_TalonSRX(5);
    motorThree = new WPI_TalonSRX(6);

  }
  public void motorOneForward(){
    motorOne.set(SPEED);
  }
  public void motorOneReverse(){
    motorOne.set(-SPEED);
  }
  public void motorTwoForward(){
    motorTwo.set(SPEED);
}
public void motorTwoReverse(){
  motorThree.set(-SPEED);
}
public void motorThreeForward(){
  motorThree.set(-SPEED);
}
public void motorOneStop(){
  motorOne.stopMotor();
}
public void motorTwoStop(){
  motorTwo.stopMotor();
}
public void motorThreeStop(){
  motorThree.stopMotor();
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
