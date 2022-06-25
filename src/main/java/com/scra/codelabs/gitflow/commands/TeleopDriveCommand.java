package com.scra.codelabs.gitflow.commands;

import com.scra.codelabs.gitflow.subsystems.ChassisSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class TeleopDriveCommand extends CommandBase {
    private final XboxController m_joystick;
    private final ChassisSubsystem m_chassisSubsystem;

    public TeleopDriveCommand(ChassisSubsystem chassisSubsystem) {
        m_chassisSubsystem = chassisSubsystem;
        m_joystick = new XboxController(0);

        addRequirements(this.m_chassisSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_chassisSubsystem.arcadeDrive(-m_joystick.getLeftY(), m_joystick.getRightX());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
