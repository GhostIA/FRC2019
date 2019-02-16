/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class GoStraightEncoder extends Command {
  long initialTime;
  public GoStraightEncoder() {
    requires(Robot.driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initialTime = System.currentTimeMillis();  
  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveTrain.drive(0.5, 0.5);
    System.out.println("is running");
   
    
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      long deltaTime = System.currentTimeMillis() - initialTime;
      return isRobotDone(deltaTime/1000, Robot.driveTrain.getVelocity());
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.drive(0, 0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
 

public double getDistance(Long time, double velocity){
  velocity = velocity/1000;
  return 6*Math.PI*velocity*time;
  }
  public boolean isRobotDone(Long time, double velocity){
    if(getDistance(time, velocity) >= 120){
      return true;
    } else{
      return false;
    }
  }
  
}