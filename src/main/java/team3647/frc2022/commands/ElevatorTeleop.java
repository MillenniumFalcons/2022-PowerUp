// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import team3647.frc2022.subsystems.Elevator;

public class ElevatorTeleop extends CommandBase {
    /** Creates a new ElevatorTeleop. */
    private final Elevator elevator;

    private final DoubleSupplier demandSupplier;

    public ElevatorTeleop(Elevator elevator, DoubleSupplier demandSupplier) {
        this.elevator = elevator;
        this.demandSupplier = demandSupplier;
        addRequirements(elevator);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double demand = demandSupplier.getAsDouble();
        elevator.setOpenLoop(demand);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
