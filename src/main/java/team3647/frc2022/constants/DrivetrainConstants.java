package team3647.frc2022.constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import team3647.lib.drivers.LazyTalonSRX;

public class DrivetrainConstants {
    public static final int kNominalVoltage = 10;
    public static final int kStallCurrent = 35;

    public static final TalonSRX leftMaster =
            new LazyTalonSRX(GlobalConstants.DrivetrainIds.leftDriveMasterPin);
    public static final TalonSRX rightMaster =
            new LazyTalonSRX(GlobalConstants.DrivetrainIds.rightDriveMasterPin);

    public static final VictorSPX leftSlave1 =
            new VictorSPX(GlobalConstants.DrivetrainIds.leftDriveSlave1Pin);
    public static final VictorSPX leftSlave2 =
            new VictorSPX(GlobalConstants.DrivetrainIds.leftDriveSlave2Pin);
    public static final VictorSPX rightSlave1 =
            new VictorSPX(GlobalConstants.DrivetrainIds.rightDriveSlave1Pin);
    public static final VictorSPX rightSlave2 =
            new VictorSPX(GlobalConstants.DrivetrainIds.rightDriveSlave2Pin);

    public static final TalonSRXConfiguration masterConfig = new TalonSRXConfiguration();

    public static final VictorSPXConfiguration slaveConfig = new VictorSPXConfiguration();

    static {
        masterConfig.continuousCurrentLimit = kStallCurrent;
        masterConfig.voltageCompSaturation = kNominalVoltage;

        slaveConfig.voltageCompSaturation = kNominalVoltage;

        leftMaster.configAllSettings(masterConfig);
        rightMaster.configAllSettings(masterConfig);

        leftSlave1.configAllSettings(slaveConfig);
        leftSlave2.configAllSettings(slaveConfig);
        rightSlave1.configAllSettings(slaveConfig);
        rightSlave2.configAllSettings(slaveConfig);

        rightMaster.setInverted(true);
        rightSlave1.setInverted(true);
        rightSlave2.setInverted(true);
    }
}
