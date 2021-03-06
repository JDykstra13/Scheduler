package org.usfirst.frc.team1339.commands;

import org.usfirst.frc.team1339.base.CommandBase;
import org.usfirst.frc.team1339.robot.Robot;

public class DriveIntake extends CommandBase {
	
	private double speed = 0;
	
    public DriveIntake() {
    	setRunSpeed(0.05);
    	requires(Robot.intake);
    }

	protected void init() {
		// TODO Auto-generated method stub
		
	}
    
    // Called repeatedly when this Command is scheduled to run
    public void execute() {

    	if (Robot.HardwareAdapter.getRightBumper().get()){
    		speed = -0.8;
    	}
    	else if(Robot.HardwareAdapter.getLeftBumper().get()){
    		speed = 0.8;
    	}
    	else{
    		speed = 0;
    	}
    	Robot.intake.intake(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end(){
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }

}
