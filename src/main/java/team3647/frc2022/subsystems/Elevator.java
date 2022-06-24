// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import team3647.lib.PeriodicSubsystem;

/** Add your docs here. */
public class Elevator implements PeriodicSubsystem {
    private final DigitalInput bannerSensor;
    private final TalonSRX leftMaster;
    private final TalonSRX rightMaster;
    private final VictorSPX leftFollower;
    private final VictorSPX rightFollower;

    private PeriodicIO pIO = new PeriodicIO();

    public static class PeriodicIO {
        public ControlMode ctrlMode = ControlMode.PercentOutput;
        public double demand = 0;
    }

    public Elevator(
            DigitalInput bannerSensor,
            TalonSRX leftMaster,
            TalonSRX rightMaster,
            VictorSPX leftFollower,
            VictorSPX rightFollower) {
        this.bannerSensor = bannerSensor;
        this.leftMaster = leftMaster;
        this.rightMaster = rightMaster;
        this.leftFollower = leftFollower;
        this.rightFollower = rightFollower;
    }

    @Override
    public void readPeriodicInputs() {}

    @Override
    public void writePeriodicOutputs() {
        leftMaster.set(pIO.ctrlMode, pIO.demand);
        rightMaster.set(pIO.ctrlMode, pIO.demand);
        leftFollower.set(pIO.ctrlMode, pIO.demand);
        rightFollower.set(pIO.ctrlMode, pIO.demand);
    }

    public void setOpenLoop(double demand) {
        pIO.ctrlMode = ControlMode.PercentOutput;
        pIO.demand = demand;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Elevator";
    }
}
