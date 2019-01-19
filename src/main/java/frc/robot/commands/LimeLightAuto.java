/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LimeLightCamera;

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
    if (!Robot.limitSwitch.isSwitchSet() == true) {
      Robot.driveTrain.drive(0, 0);
    } else {
      double xCoord = Robot.limeLightCamera.getX();
      double yCoord = Robot.limeLightCamera.getY();
      Robot.driveTrain.drive(Robot.oi.getJoystick1().getY(), Robot.oi.getJoystick2().getY());
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
