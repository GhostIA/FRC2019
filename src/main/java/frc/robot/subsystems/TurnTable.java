/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;;

/**
 * Add your docs here.
 */
public class TurnTable extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX turnTableMotor;
  public TurnTable(){
    super();
    turnTableMotor = new WPI_TalonSRX(2);
  }

  public void turnTableForward(){
    turnTableMotor.set(0.5);
  }
  public void turnTableReverse(){
    turnTableMotor.set(-0.5);
  }
  public void turnTableStop(){
    turnTableMotor.set(0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
