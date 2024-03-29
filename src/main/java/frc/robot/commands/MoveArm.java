/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.RotatingControl;

public class MoveArm extends Command {

  private RotatingControl rotatingControl;
  private boolean forward;

  public MoveArm(RotatingControl rotatingControl, boolean forward) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.rotatingControl = rotatingControl;
    this.forward = forward;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(Robot.oi.isButtonGoingUp() == true){
      System.out.println(Robot.oi.isButtonGoingUp());
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("direction: " + forward);
    rotatingControl.turn(forward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    rotatingControl.stop();
  }
}
