package team3647.frc2022.constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import edu.wpi.first.wpilibj.DigitalInput;
import team3647.lib.drivers.LazyTalonSRX;

public class ElevatorConstants {
    public static final DigitalInput bannerSensor =
            new DigitalInput(GlobalConstants.ElevatorIds.bannerSensorPin);
    public static final TalonSRX leftMaster =
            new LazyTalonSRX(GlobalConstants.ElevatorIds.leftMasterPin);
    public static final TalonSRX rightMaster =
            new LazyTalonSRX(GlobalConstants.ElevatorIds.rightMasterPin);
    public static final VictorSPX leftSlave =
            new VictorSPX(GlobalConstants.ElevatorIds.leftFollowerPin);
    public static final VictorSPX rightSlave =
            new VictorSPX(GlobalConstants.ElevatorIds.rightFollowerPin);

    public static final TalonSRXConfiguration leftMasterConfig = new TalonSRXConfiguration();
    public static final TalonSRXConfiguration rightMasterConfig = new TalonSRXConfiguration();

    public static final VictorSPXConfiguration leftSlaveConfig = new VictorSPXConfiguration();
    public static final VictorSPXConfiguration rightSlaveConfig = new VictorSPXConfiguration();

    public static final int kNominalVoltage = 10;
    public static final int kStallCurrent = 35;

    static {
        leftMasterConfig.continuousCurrentLimit = kStallCurrent;
        leftMasterConfig.voltageCompSaturation = kNominalVoltage;

        rightMasterConfig.continuousCurrentLimit = kStallCurrent;
        rightMasterConfig.voltageCompSaturation = kNominalVoltage;

        leftSlaveConfig.voltageCompSaturation = kNominalVoltage;

        rightSlaveConfig.voltageCompSaturation = kNominalVoltage;

        leftMaster.configAllSettings(leftMasterConfig);
        rightMaster.configAllSettings(rightMasterConfig);
        leftSlave.configAllSettings(leftSlaveConfig);
        rightSlave.configAllSettings(rightSlaveConfig);

        rightMaster.setInverted(true);
        rightSlave.setInverted(true);
    }
}
