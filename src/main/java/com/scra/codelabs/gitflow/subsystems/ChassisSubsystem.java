package com.scra.codelabs.gitflow.subsystems;


import com.scra.codelabs.gitflow.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ChassisSubsystem extends SubsystemBase {

    private final MotorController m_leftDriveA;
    private final MotorController m_rightDriveA;

    private final DifferentialDrive m_differentialDrive;

    @SuppressWarnings("PMD.CloseResource")
    public ChassisSubsystem() {

        m_leftDriveA = new Talon(Constants.DRIVE_LEFT_A);
        m_rightDriveA = new Talon(Constants.DRIVE_RIGHT_A);

        MotorController leftDriveB = new Talon(Constants.DRIVE_LEFT_B);
        MotorController rightDriveB = new Talon(Constants.DRIVE_RIGHT_B);

        m_differentialDrive = new DifferentialDrive(new MotorControllerGroup(m_leftDriveA, leftDriveB),
                new MotorControllerGroup(m_rightDriveA, rightDriveB));
    }

    public void arcadeDrive(double speed, double steer) {
        m_differentialDrive.arcadeDrive(speed, steer);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Left Drive", m_leftDriveA.get());
        SmartDashboard.putNumber("Right Drive", m_rightDriveA.get());
    }
}
