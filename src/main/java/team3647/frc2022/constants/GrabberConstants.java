// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;

/** Add your docs here. */
public class GrabberConstants {
    public static final Solenoid leftPiston =
            new Solenoid(GlobalConstants.PCMType, GlobalConstants.GrabberIds.intakeLeftPiston);
    public static final Solenoid rightPiston =
            new Solenoid(GlobalConstants.PCMType, GlobalConstants.GrabberIds.intakeRightPiston);
    public static final VictorSPX leftIntakeMotor =
            new VictorSPX(GlobalConstants.GrabberIds.leftIntakePin);
    public static final VictorSPX rightIntakeMotor =
            new VictorSPX(GlobalConstants.GrabberIds.rightIntakePin);

    // private final VictorSPXConfiguration intakeConfig = new VictorSPXConfiguration();

    static {
        rightIntakeMotor.setInverted(true);
    }
}
