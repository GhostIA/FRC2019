/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimeLightAuto extends Command {
  
  public LimeLightAuto() {
    requires(Robot.limeLightCamera);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
  protected void initialize() {
    
    super.initialize();

    Robot.limeLightCamera.setPipeline(0);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double left = 4;
    double right = 5;
    System.out.println("Auto called");
    if (!Robot.limitSwitch.isSwitchSet() == true) {
      Robot.driveTrain.drive(0, 0);
    } else {
      double xCoord = Robot.limeLightCamera.getX();
      double yCoord = Robot.limeLightCamera.getY();
     
      if(xCoord >= left){
        Robot.driveTrain.drive(-1, 1);
      } else{
        Robot.driveTrain.drive(1, -1);
      }
    }

    double area = Robot.limeLightCamera.getArea();
    System.out.println(area);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
