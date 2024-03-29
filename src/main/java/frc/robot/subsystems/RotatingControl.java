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
public class RotatingControl extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX motor;
  private static final double SPEED = .1;
  private static final long TURN_TIME = 35000;
  private boolean isHolding = false;
  private long startTime;

  public RotatingControl(int port) {
    super();
    motor = new WPI_TalonSRX(port);
    motor.set(0);
  }

  public void turn(boolean forward) {
    motor.set(forward ? SPEED * 8 : SPEED * -3);
  }

  public void stop() {
    motor.set(0);
  }
  public void lock(){
    if(!isHolding){
      startTime = System.currentTimeMillis();
      isHolding = true;
      return;
    }
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(elapsedTime < TURN_TIME){
      return;
    }

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
