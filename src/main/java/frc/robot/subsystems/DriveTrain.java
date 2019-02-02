/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.commands.TankDriveWithJoystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;




/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private WPI_TalonSRX frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

	
	long startTime = 0;

	private DifferentialDrive drive;
	

	public DriveTrain() {
		super();

			
			frontLeftMotor = new WPI_TalonSRX(0);
			frontRightMotor = new WPI_TalonSRX(1);
			frontLeftMotor.setInverted(true);
			frontRightMotor.setInverted(true);
			frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);

		
		
		drive = new DifferentialDrive(frontRightMotor, frontLeftMotor);


		// Let's show everything on the LiveWindow

	
	}





	/**
	 * When no other command is running let the operator drive around using the
	 * PS3 joystick.
	 */
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
//		setDefaultCommand(new WinchForward());
//    	setDefaultCommand(new WinchReverse());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}

	public void drive(double left, double right) {
	
			drive.tankDrive(left, right);
			System.out.println("drive is running");
		}
		
	public int getEncoderPosition(){
		int position = frontLeftMotor.getSelectedSensorPosition();
		return position;
	}
	public int getWidth(){
		int width = frontLeftMotor.getSensorCollection().getPulseWidthPosition();
		return width;
	}
	public void setSafetyAndExpiration(boolean safety, double expiration) {
		drive.setExpiration(expiration);
		drive.setSafetyEnabled(safety);
	}
	public double getVelocity(){
		double velocity = frontLeftMotor.getSelectedSensorVelocity();
		return velocity;
	}
}
