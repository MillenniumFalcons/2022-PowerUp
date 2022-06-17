package team3647.frc2022.constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import edu.wpi.first.wpilibj.DigitalInput;
import team3647.lib.drivers.LazyTalonSRX;

public class ElevatorConstants {
    public static final DigitalInput bannerSensor =
            new DigitalInput(GlobalConstants.ElevatorIds.bannerSensorPin);
    public static final TalonSRX leftMaster =
            new LazyTalonSRX(GlobalConstants.ElevatorIds.leftMasterPin);
    public static final VictorSPX leftFollower =
            new VictorSPX(GlobalConstants.ElevatorIds.leftFollowerPin);
    public static final TalonSRX rightMaster =
            new LazyTalonSRX(GlobalConstants.ElevatorIds.rightMasterPin);
    public static final VictorSPX rightFollower =
            new VictorSPX(GlobalConstants.ElevatorIds.rightFollowerPin);

    public static VictorSPXConfiguration getLeftFollowerConfig() {
        VictorSPXConfiguration config = new VictorSPXConfiguration();
    }

    static {
    }
}
