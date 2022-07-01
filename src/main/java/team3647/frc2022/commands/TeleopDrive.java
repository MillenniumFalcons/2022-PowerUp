// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import team3647.frc2022.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
    /** Creates a new TeleopDrive. */
    private final Drivetrain dt;

    private final DoubleSupplier throttle;
    private final DoubleSupplier turn;
    private final BooleanSupplier isQuickTurn;

    private final double driveMultiplier = 0.4;

    public TeleopDrive(
            Drivetrain dt,
            DoubleSupplier throttle,
            DoubleSupplier turn,
            BooleanSupplier isQuickTurn) {
        this.dt = dt;
        this.throttle = throttle;
        this.turn = turn;
        this.isQuickTurn = isQuickTurn;
        addRequirements(dt);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double throttleDemand = throttle.getAsDouble() * driveMultiplier;
        double turnDemand = turn.getAsDouble() * driveMultiplier;
        boolean quickTurn = isQuickTurn.getAsBoolean();

        dt.curvatureDrive(throttleDemand, turnDemand, quickTurn);
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
