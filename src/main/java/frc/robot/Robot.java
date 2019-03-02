/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.FinalAutonomous;
import frc.robot.commands.LimeLightAuto;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLightCamera;
import frc.robot.subsystems.LimitSwitches;
import frc.robot.subsystems.TurnTable;
import frc.robot.commands.ArmOneForward;
import frc.robot.commands.DriveStraighForXSeconds;
import frc.robot.subsystems.USBCameraServer;
import frc.robot.subsystems.ArmControlConsole;
import frc.robot.subsystems.Piston;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
import frc.robot.subsystems.ArmSubsystem;
public class Robot extends TimedRobot {
  
  public static OI oi;
  public static DriveTrain driveTrain;
  public static LimeLightCamera limeLightCamera;
  public static LimitSwitches limitSwitch;
  public static USBCameraServer camera;
  public static TurnTable turnTable;
  public static ArmSubsystem armControls;
  public static Piston piston;
  Command autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  Command teleopCommand;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() { 
    turnTable = new TurnTable();
    oi = new OI();
   
    driveTrain = new DriveTrain();
    limeLightCamera = new LimeLightCamera();
    limitSwitch = new LimitSwitches();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    autonomousCommand = new FinalAutonomous();
    camera = new USBCameraServer();
    armControls = new ArmSubsystem();
    piston = new Piston();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
   // Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = m_chooser.getSelected();
    autonomousCommand = new FinalAutonomous();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
    driveTrain.setSafetyAndExpiration(false, 0.1);
		System.out.println("teleopInit called");
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }

    // // this is the code for the buttons. commented out for now. Make sure you uncomment in OI
    // ArmControlConsole.Action action = oi.getNextAction();

    // if(action == ArmControlConsole.Action.LOADING_LOW) {
    //   // move arm low
    // }

    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    if (isOperatorControl() && isEnabled()) {		
            driveTrain.setSafetyAndExpiration(false, 0.1);
            Scheduler.getInstance().run();
//            System.out.println("tele periodic is running");
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
