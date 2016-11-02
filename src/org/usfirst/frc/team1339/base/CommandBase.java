package org.usfirst.frc.team1339.base;

import org.usfirst.frc.team1339.robot.Robot;
import org.usfirst.frc.team1339.subsystems.Chassis;
import org.usfirst.frc.team1339.subsystems.Intake;
import org.usfirst.frc.team1339.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;

/**
 * 
 * @author Sam Schwartz
 * @author Nate Howard
 * @author Sam Korman
 * @see Timer
 *
 */

public abstract class CommandBase {
	
	private double m_time = -1;
	private double startTime;
	
	private boolean initialized = false;
	
	public abstract void init();
	
	public abstract void execute();
	
	public abstract boolean isFinished();
	
	public abstract void end();
	
	public abstract void interrupted();
	
	public boolean isInitialized(){
		return initialized;
	}
	
	public void setInitialized(){
		initialized = true;
	}
	
	protected void setTimeout(double time){
		m_time = Math.abs(time);
		startTime = Timer.getFPGATimestamp();
	}
	
	protected boolean isTimedOut(){
		if (m_time < 0) return false;
		if (Timer.getFPGATimestamp() > startTime + m_time){
			return true;
		}
		return false;
	}
	
	public boolean isCommandGroup(){
		return false;
	}
}