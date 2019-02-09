/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ArmControlConsole.Action;

public class TurnTableForward extends Command {
  public TurnTableForward() {
    requires(Robot.turnTable);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

      Robot.turnTable.turn(true);

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.oi.isTurnButtonSet() == true){
      return false;
    }  else{
      return true;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.turnTable.turn(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
