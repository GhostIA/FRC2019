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
  private long startTime = 0;
  private boolean isTurning = false;

  private static final long TURN_TIME = 1000;
  private static final double SPEED = 0.5;
  private static final int PORT = 3;

  public TurnTable() {
    super();
    turnTableMotor = new WPI_TalonSRX(PORT);
    turnTableMotor.set(0);
  }

  // this is for debugging
  public void setMotor(WPI_TalonSRX turnTableMotor) {
    this.turnTableMotor = turnTableMotor;
  }

  public void reset() {
    turnTableMotor.set(0);
    startTime = 0;
    isTurning = false;
  }

  // must call reset() prior to a turn. then call turn(ture|false) in iterative.
  // it will stop
  // when time reached
  // e.g.
  // execute() {
  // if(buttonPressed) {
  // turnTable.reset();
  // turnTable.turn(true);
  // }
  // }

  public synchronized void turn(boolean forward) {
    if (!isTurning) {
      System.out.println("Starting...");
      startTime = System.currentTimeMillis();
      isTurning = true;
      iterativeTurn(forward);
      return;
    }

    long elapsedTime = System.currentTimeMillis() - startTime;
    if (elapsedTime < TURN_TIME) {
      return;
    }
    System.out.println("turn ended");
    turnTableMotor.set(0);
  }

  private synchronized void iterativeTurn(boolean forward) {
    if (forward) {
      turnTableMotor.set(SPEED);
    } else {
      turnTableMotor.set(-SPEED);
    }
  }

  public void stop() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
