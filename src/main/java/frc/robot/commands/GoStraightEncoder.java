/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class GoStraightEncoder extends Command {

  public GoStraightEncoder() {
    requires(Robot.driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  
  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double velocity, time, distance;
    double FINAL_DISTANCE;
    Timer timer = new Timer();
    
    Robot.driveTrain.drive(0.5, 0.5);
    velocity = Robot.driveTrain.getVelocity();
    time = timer.get();
    distance = time * velocity;
    FINAL_DISTANCE = 7.0;
    if(distance >= FINAL_DISTANCE){
      Robot.driveTrain.drive(0, 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.driveTrain.getVelocity() == 0){
      return true;
    } else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
