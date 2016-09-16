
package com.team980.robot2016;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private RobotDrive robotDrive;
	
	private Joystick driveStick;
	private Joystick driveWheel;
	
	private Encoder leftDriveEnc;
	private Encoder rightDriveEnc;
	
	private Joystick controlStick;
	
	private CANTalon armMotor;
	private CANTalon rollerMotor;
	
	
	public Robot() {
		robotDrive = new RobotDrive(Parameters.leftDriveMotorChannel, Parameters.rightDriveMotorChannel);
		robotDrive.setExpiration(0.1); //TODO what does this do
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true); //TODO not parameterized
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		robotDrive.setMaxOutput(Parameters.maxDriveOutput);
		
		driveStick = new Joystick(Parameters.driveJsChannel);
		driveWheel = new Joystick(Parameters.driveWheelChannel);
		
		leftDriveEnc = new Encoder(Parameters.leftDriveEncA, Parameters.leftDriveEncB);
		leftDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); 
		leftDriveEnc.setReverseDirection(Parameters.leftDriveEncInv);
		
		rightDriveEnc = new Encoder(Parameters.rightDriveEncA, Parameters.rightDriveEncB);
		rightDriveEnc.setDistancePerPulse(2*Constants.pi*(Constants.wheelRadius/Constants.inchesInFeet)/Parameters.driveEncoderCounts); 
		rightDriveEnc.setReverseDirection(Parameters.rightDriveEncInv);
		
		controlStick = new Joystick(Parameters.controlJsChannel);
		
		armMotor = new CANTalon(Parameters.rollerMotorChannel);
		armMotor.setControlMode(CANTalon.TalonControlMode.Position.getValue());
		armMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		//TODO finish PID on arm encoder
		
		rollerMotor = new CANTalon(Parameters.rollerMotorChannel);
	}
		
    public void robotInit() {
    	CameraServer.getInstance().setQuality(25);
    	CameraServer.getInstance().startAutomaticCapture("cam0");
    }
    
    public void autonomousInit() {
    	leftDriveEnc.reset();
    	rightDriveEnc.reset();
    	
    	//TODO init arm & roller motors
    }

    public void autonomousPeriodic() {
    	
    	double currentDistLeft = leftDriveEnc.getDistance();
    	double currentDistRight = rightDriveEnc.getDistance();
    	
    	if (currentDistLeft > Parameters.autoDistance &&
    			currentDistRight > Parameters.autoDistance) {
    		robotDrive.setLeftRightMotorOutputs(0, 0); //stops the robot
    	} else {
    		robotDrive.setLeftRightMotorOutputs(Parameters.leftAutoSpeed, Parameters.rightAutoSpeed);
    	}
    	
    	SmartDashboard.putNumber("Current Distance - Left", currentDistLeft);
    	SmartDashboard.putNumber("Current Distance - Right", currentDistRight);
    }
    
    public void teleopInit() {
    	//TODO init arm motor
    }

    public void teleopPeriodic() {
        robotDrive.arcadeDrive(driveStick, Joystick.AxisType.kY.value, driveWheel, Joystick.AxisType.kX.value, false);
        //TODO implement custom drive system
        
        //TODO implement arm system
        
        //TODO print to SmartDashboard
    }
    
    public void disabledInit() {
    	armMotor.disableControl();
    	rollerMotor.disableControl();
    }
    
}
