package com.scra.codelabs.gitflow.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class PJExampleCommand extends CommandBase {

    public PJExampleCommand() {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();

        System.out.println("PJ makes an example");
    }
}
