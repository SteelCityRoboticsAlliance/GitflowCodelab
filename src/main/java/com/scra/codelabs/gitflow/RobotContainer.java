// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.scra.codelabs.gitflow;

import com.scra.codelabs.gitflow.commands.PJExampleCommand;
import com.scra.codelabs.gitflow.commands.TeleopDriveCommand;
import com.scra.codelabs.gitflow.subsystems.ChassisSubsystem;
import com.scra.codelabs.gitflow.subsystems.SubsystemOne;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class RobotContainer {
    private static final String DRIVETRAIN_NAME = "m_drivetrain";

    private PJExampleCommand m_pjExample;
    private final SubsystemOne m_sSubsystemOne;

    ///////////////////////////////////////
    // Don't touch things below here
    ///////////////////////////////////////

    private final ChassisSubsystem m_drivetrain;

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        m_drivetrain = new ChassisSubsystem();
        m_sSubsystemOne = new SubsystemOne();

        Field[] fields = RobotContainer.class.getDeclaredFields();

        List<String> sortedNames = new ArrayList<>();
        for (Field field : fields) {
            if (!DRIVETRAIN_NAME.equals(field.getName())) {
                sortedNames.add(field.getType().getName());
            }
        }

        sortedNames.sort(String::compareTo);

        System.out.println("\n\n\n\n********************************************************");
        for (String className : sortedNames) {
            try {
                Class<?> clazz = Class.forName(className);
                clazz.getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace(); // NOPMD
            }
        }
        System.out.println("********************************************************\n\n\n\n");

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings() {
        m_drivetrain.setDefaultCommand(new TeleopDriveCommand(m_drivetrain));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return null;
    }
}
