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
  private long elapsedTime;
  private boolean isTurning;

  private static final long TURN_TIME = 1000;
  private static final double SPEED = 0.5;
  private static final int PORT = 2;

  public TurnTable(){
    super();
    turnTableMotor = new WPI_TalonSRX(PORT);
    turnTableMotor.set(0);
  }

  public void reset() {
    isTurning = false;
    elapsedTime = 0;
  }

  // must call reset() prior to a turn. then call turn(ture|false) in iterative. it will stop 
  // when time reached
  // e.g.
  // execute() {
  //  if(buttonPressed) {
  //     turnTable.reset();
  //    turnTable.turn(true);
  //  }
  // }

  public void turn(boolean forward) {
    if(!isTurning) {
      elapsedTime = 0;
      isTurning = true;
      iterativeTurn(forward);
      return;
    }

    if(System.currentTimeMillis() - elapsedTime < TURN_TIME) {
      iterativeTurn(forward);
    }
    else {
      turnTableMotor.set(0);
    }
  }

  private void iterativeTurn(boolean forward){
    if(forward) {
      turnTableMotor.set(SPEED);
    }
    else { 
      turnTableMotor.set(-SPEED);
    }
  }

  public void stop(){
    
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
