/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.LimeLightAuto;
import frc.robot.subsystems.ArmControlConsole;
import frc.robot.commands.TurnTableForward;
import frc.robot.commands.ActivatePiston;
import frc.robot.commands.MoveArm;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private Joystick joy1 = new Joystick(0);
  private Joystick joy2 = new Joystick(1);
  private Joystick joy3 = new Joystick(2);
  private ArmControlConsole armControlConsole = new ArmControlConsole(3);
  private JoystickButton vision = new JoystickButton(joy1, 3);
  private JoystickButton turnTableButton = new JoystickButton(joy2, 5);
  private JoystickButton armOneForwardButton = new JoystickButton(joy2, 1);
  // private JoystickButton pistonButton = new JoystickButton(joy2, 2);
  private JoystickButton pistonButton1 = new JoystickButton(joy2, 1);
  private JoystickButton pistonButton2 = new JoystickButton(joy2, 2);
  private JoystickButton armForwardButton = new JoystickButton(joy2, 3);
  private JoystickButton armReverseButton = new JoystickButton(joy2, 4);
  
  public OI(){
    vision.whileHeld(new LimeLightAuto());
    turnTableButton.whileHeld(new TurnTableForward());
    armForwardButton.whileHeld(new MoveArm(Robot.arm, true));
    armReverseButton.whileHeld(new MoveArm(Robot.arm, false));
    pistonButton1.whileHeld(new ActivatePiston(Robot.piston1));
  
  }
  public Joystick getJoystick1(){
    return joy1;

  }
  public Joystick getJoystick2(){
    return joy2;
  }
  public boolean getVisionButton(){
    return vision.get();
  }

  public ArmControlConsole.Action getNextAction() {
    return armControlConsole.getNextAction();
  }
  public boolean isTurnButtonSet(){
    return turnTableButton.get();
  }
  public boolean isButtonGoingUp(){
    return armForwardButton.get();
  }
}
