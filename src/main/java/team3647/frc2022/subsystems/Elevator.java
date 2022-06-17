// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team3647.frc2022.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import team3647.lib.PeriodicSubsystem;

/** Add your docs here. */
public class Elevator implements PeriodicSubsystem {
    private DigitalInput bannerSensor;
    private TalonSRX leftMaster;
    private TalonSRX rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;

    public class PeriodicIO {
        public double elevatorPositionl = 0;
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

    public void openLoop(double input) {}

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
}
