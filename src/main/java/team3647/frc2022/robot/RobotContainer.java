// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import team3647.frc2022.commands.ElevatorTeleop;
import team3647.frc2022.commands.TeleopDrive;
import team3647.frc2022.constants.DrivetrainConstants;
import team3647.frc2022.constants.ElevatorConstants;
import team3647.frc2022.constants.GrabberConstants;
import team3647.frc2022.subsystems.Drivetrain;
import team3647.frc2022.subsystems.Elevator;
import team3647.frc2022.subsystems.Grabber;
import team3647.lib.inputs.Joysticks;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private final Joysticks mainController = new Joysticks(0);
    private final Joysticks coController = new Joysticks(1);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        m_scheduler.registerSubsystem(m_drivetrain, m_elevator, m_grabber);
        m_drivetrain.setDefaultCommand(
                new TeleopDrive(
                        m_drivetrain,
                        mainController::getLeftStickY,
                        mainController::getLeftStickX,
                        () -> true));
        m_elevator.setDefaultCommand(new ElevatorTeleop(m_elevator, coController::getLeftStickY));
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        coController.leftTrigger.whileActiveOnce(new RunCommand(m_grabber::intake, m_grabber));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }

    private final CommandScheduler m_scheduler = CommandScheduler.getInstance();

    private final Drivetrain m_drivetrain =
            new Drivetrain(
                    DrivetrainConstants.leftMaster,
                    DrivetrainConstants.rightMaster,
                    DrivetrainConstants.leftSlave1,
                    DrivetrainConstants.leftSlave2,
                    DrivetrainConstants.rightSlave1,
                    DrivetrainConstants.rightSlave2);
    private final Elevator m_elevator =
            new Elevator(
                    ElevatorConstants.bannerSensor,
                    ElevatorConstants.leftMaster,
                    ElevatorConstants.rightMaster,
                    ElevatorConstants.leftSlave,
                    ElevatorConstants.rightSlave);

    private final Grabber m_grabber =
            new Grabber(
                    GrabberConstants.leftPiston,
                    GrabberConstants.rightPiston,
                    GrabberConstants.leftIntakeMotor,
                    GrabberConstants.rightIntakeMotor);
}
