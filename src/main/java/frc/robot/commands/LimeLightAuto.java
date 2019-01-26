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
    final double LEFT = 4;
    final double RIGHT = 5;
    System.out.println("Auto called");
    if (!Robot.limitSwitch.isSwitchSet() == true) {
      Robot.driveTrain.drive(0, 0);
    } else {
      double xCoord = Robot.limeLightCamera.getX();
      double yCoord = Robot.limeLightCamera.getY();
      System.out.println(" x coord " + xCoord + " y coord " + yCoord);

      double leftControl = 0, rightControl = 0;
      if(xCoord == 0 || yCoord == 0){
        // leftControl=-.9;
        // rightControl=+.9;
       
       } else{
        if(xCoord > -3){          
          leftControl=-0.6;
          rightControl=-0.6;
          System.out.println("going straight");
        } else if(xCoord < -8){       
          leftControl=-.45;
          rightControl=-.15;
          System.out.println("going right");
          
         } else if(xCoord > 3){
          System.out.println("going left");
        
          leftControl=-.15;
          rightControl=-.45;
          
        }
        
        
      }
      System.out.println(leftControl);
      System.out.println(rightControl);
      Robot.driveTrain.drive(leftControl, rightControl);
      
      
    }

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
