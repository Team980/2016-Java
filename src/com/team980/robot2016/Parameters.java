package com.team980.robot2016;

public class Parameters {
	
	// --- DRIVE SYSTEM ---
	public static int leftDriveMotorChannel = 1;
	public static int rightDriveMotorChannel = 0;
	
	public static double leftMotorMultiplier = 1.0; //TODO determine these values
	public static double rightMotorMultiplier = 1.0; //TODO based on encoder tuning
	
	// --- AUTONOMOUS ---
	public static double autoDistance = 15.0; //feet
	public static double autoSpeed = 1.0;
	
	// --- ENCODERS --- 
	public static int leftDriveEncA = 3;
	public static int leftDriveEncB = 4;
	public static boolean leftDriveEncInv = false;
	
	public static int rightDriveEncA = 1;
	public static int rightDriveEncB = 2;
	public static boolean rightDriveEncInv = true;
	
	public static int driveEncoderCounts = 1024;
	
	// --- JOYSTICKS / DRIVER INPUTS ---
	public static int driveJsChannel = 0;
}
