/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;

public class LimeLightAuto extends Command {

  public LimeLightAuto() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
  protected void initialize() {

    super.initialize();

    Robot.limeLightCamera.setPipeline(0);

  }

  private static enum Direction {
    left, straight, right
  };

  private Direction direction = Direction.straight;
  private long lastActionTime = 0;

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    // System.out.println("Auto called");
    if (!Robot.limitSwitch.isSwitch1Set() == true) {
      Robot.driveTrain.drive(0, 0);
      return;
    }

    if (System.currentTimeMillis() - lastActionTime < 3000) {
      double xCoord = Robot.limeLightCamera.getX();
      double yCoord = Robot.limeLightCamera.getY();
      
     // System.out.println(" x coord " + xCoord + " y coord " + yCoord);
      if (xCoord == 0 && yCoord == 0) {
        return;
      }
      if (xCoord >= -5 && xCoord <= 5) {
        direction = Direction.straight;
      } else if (xCoord < -5) {
        direction = Direction.left;
      } else if (xCoord > 5) {
        direction = Direction.right;
      }
    }

    switch (direction) {
    case left:
      goLeft();
      break;
    case right:
      goRight();
      break;
    default:
      goStraight();
    }

    lastActionTime = System.currentTimeMillis();
  }
  private void goStraight() {
    double area = Robot.limeLightCamera.getArea();
    if(area < 3){
      
      Robot.driveTrain.drive(-.8,-.8);
    } else{
      Robot.driveTrain.drive(-0.5,-0.5);
      
      //System.out.println(Robot.driveTrain.getSpeed());

    }
    
    //System.out.println(area);
   
    
  }

  private void goLeft() {
    double area = Robot.limeLightCamera.getArea();
    if(area < 3){
    Robot.driveTrain.drive(-.85, .00);
    } else{
      Robot.driveTrain.drive(.5, -.5);
    }
  //  System.out.println("going left");
  }

  private void goRight() {
    double area = Robot.limeLightCamera.getArea();
    if(area < 3){
    Robot.driveTrain.drive(.00, -.85);
    } else{
      Robot.driveTrain.drive(.5, -.5);
    }
    //  System.out.println("going right");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.drive(0, 0);
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
