/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Add your docs here.
 */
public class TurnLeft extends TimedCommand {
  /**
   * Add your docs here.
   */
  public TurnLeft(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean dbButton = SmartDashboard.getBoolean("DB/Button 1", false);
    if(dbButton == true){
      Robot.driveTrain.drive(0.8, -0.8);
    } else{
      Robot.driveTrain.drive(-0.8, 0.8);
    }
    
  }

  // Called once after timeout
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
