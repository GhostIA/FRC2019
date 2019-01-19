/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.LimeLightAuto;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 * Add your docs here.
 */
public class LimeLightCamera extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.4
  private NetworkTable table;
  public LimeLightCamera(){
    table  = NetworkTableInstance.getDefault().getTable("limelight");

  }
   
  public static enum LightMode {
		eOn, eOff, eBlink
	}public static enum CameraMode {
		eVision, eDriver
	}
  public double getX(){
    NetworkTableEntry tx = table.getEntry("tx");
    double x = tx.getDouble(0.0);
    return x;
  }
  
  public double getY(){
    NetworkTableEntry ty = table.getEntry("ty");
    double y = ty.getDouble(0.0);
    return y;
  } 
  
  
  public double getArea(){
    NetworkTableEntry ta = table.getEntry("ta");
    double area = ta.getDouble(0.0);
    return area;
  }
  public boolean isTarget() {
		return getY() == 1.0;
	}
  
  public void setPipeline(int number){
    table.getEntry("pipeline").setNumber(number);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LimeLightAuto());
  }

}
