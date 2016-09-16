package com.team980.robot2016;

public class Parameters {
	
	// --- DRIVE SYSTEM ---
	public static int leftDriveMotorChannel = 1;
	public static int rightDriveMotorChannel = 0;
	public static double maxDriveOutput = 0.6;
	
	// --- AUTONOMOUS ---
	public static double autoDistance = 8.0; //feet - TODO set to 22.0 for comp
	public static double leftAutoSpeed = -0.78;
	public static double rightAutoSpeed = -0.8;
	
	// --- ENCODERS --- 
	public static int leftDriveEncA = 3;
	public static int leftDriveEncB = 4;
	public static boolean leftDriveEncInv = false;
	
	public static int rightDriveEncA = 1;
	public static int rightDriveEncB = 2;
	public static boolean rightDriveEncInv = true;
	
	public static int driveEncoderCounts = 1024;
	
	// --- ARM SYSTEM ---
	public static int rollerMotorChannel = 1;
	public static int armMotorChannel = 2;
	
	public static double rollerInSpeed = 1.0;
	public static double rollerOutSpeed = -1.0;
	
	// --- ARM SYSTEM PID ---
	//TODO
	
	// --- JOYSTICKS / DRIVER INPUTS ---
	public static int driveJsChannel = 0;
	public static int driveWheelChannel = 1;
	
	public static int controlJsChannel = 2;
	
	public static int controlJsRollerInButton = 3;
	public static int controlJsRollerOutButton = 2;
		
	public static int controlJsArmDownButton = 7;
	public static int controlJsArmUpButton = 6;
}
