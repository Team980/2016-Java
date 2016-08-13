
package com.team980.robot2016;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	
	private Joystick driveStick;
	
	private Encoder leftDriveEnc;
	private Encoder rightDriveEnc;
	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftDriveMotorChannel, Parameters.rightDriveMotorChannel);
		
		driveStick = new Joystick(Parameters.driveJsChannel);
		
		leftDriveEnc = new Encoder(Parameters.leftDriveEncA, Parameters.leftDriveEncB);
		leftDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); 
		leftDriveEnc.setReverseDirection(Parameters.leftDriveEncInv);
		
		rightDriveEnc = new Encoder(Parameters.rightDriveEncA, Parameters.rightDriveEncB);
		rightDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); 
		rightDriveEnc.setReverseDirection(Parameters.rightDriveEncInv);
	}
		
    public void robotInit() {
    	CameraServer.getInstance().setQuality(50);
    	CameraServer.getInstance().startAutomaticCapture("cam0");
    }
    
    public void autonomousInit() {
    	leftDriveEnc.reset();
    	rightDriveEnc.reset();
    }

    public void autonomousPeriodic() {
    	
    	double currentDistLeft = leftDriveEnc.getDistance();
    	double currentDistRight = rightDriveEnc.getDistance();
    	
    	if (currentDistLeft > Parameters.autoDistance &&
    			currentDistRight > Parameters.autoDistance) {
    		robotDrive.setLeftRightMotorOutputs(0, 0); //stops the robot
    	} else {
    		robotDrive.setLeftRightMotorOutputs(Parameters.leftMotorMultiplier * Parameters.autoSpeed, 
    				Parameters.rightMotorMultiplier * Parameters.autoSpeed);
    	}
    	
    	SmartDashboard.putNumber("Current Distance - Left", currentDistLeft);
    	SmartDashboard.putNumber("Current Distance - Right", currentDistRight);
    }

    public void teleopPeriodic() {
        robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveStick, Joystick.AxisType.kZ.value);
    }
    
    public void testPeriodic() {
    
    }
    
}
