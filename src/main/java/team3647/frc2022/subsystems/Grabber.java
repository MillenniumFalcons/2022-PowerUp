// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import team3647.lib.PeriodicSubsystem;

/** Add your docs here. */
public class Grabber implements PeriodicSubsystem {
    private final Solenoid grabPiston1;
    private final Solenoid grabPiston2;
    private final VictorSPX leftIntakeMotor;
    private final VictorSPX rightIntakeMotor;

    private PeriodicIO pIO = new PeriodicIO();

    public static class PeriodicIO {
        public ControlMode intakeControlMode = ControlMode.PercentOutput;
        public double intakeDemand = 0;
        public boolean pistonExtended = false;
    }

    public Grabber(
            Solenoid grabPiston1,
            Solenoid grabPiston2,
            VictorSPX leftIntakeMotor,
            VictorSPX rightIntakeMotor) {
        this.grabPiston1 = grabPiston1;
        this.grabPiston2 = grabPiston2;
        this.rightIntakeMotor = rightIntakeMotor;
        this.leftIntakeMotor = leftIntakeMotor;
    }

    @Override
    public void readPeriodicInputs() {}

    @Override
    public void writePeriodicOutputs() {
        this.grabPiston1.set(pIO.pistonExtended);
        this.grabPiston2.set(pIO.pistonExtended);
        this.rightIntakeMotor.set(pIO.intakeControlMode, pIO.intakeDemand);
        this.leftIntakeMotor.set(pIO.intakeControlMode, pIO.intakeDemand);
    }

    public void clamp() {
        pIO.pistonExtended = true;
    }

    public void release() {
        pIO.pistonExtended = false;
    }

    public void intake() {
        pIO.intakeControlMode = ControlMode.PercentOutput;
        pIO.intakeDemand = 0.4;
        clamp();
    }

    public void outtake() {
        pIO.intakeControlMode = ControlMode.PercentOutput;
        pIO.intakeDemand = -0.4;
        clamp();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Grabber";
    }
}
