package team3647.frc2022.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import team3647.lib.PeriodicSubsystem;

public class Drivetrain implements PeriodicSubsystem {
    private final TalonSRX leftMaster;
    private final TalonSRX rightMaster;

    private final VictorSPX leftSlave1;
    private final VictorSPX leftSlave2;
    private final VictorSPX rightSlave1;
    private final VictorSPX rightSlave2;

    private PeriodicIO pIO = new PeriodicIO();

    public static class PeriodicIO {
        public DifferentialDriveWheelSpeeds wheelSpeeds = new DifferentialDriveWheelSpeeds();
        public ControlMode ctrlMode = ControlMode.PercentOutput;
        public double leftOutput = 0;
        public double rightOutput = 0;
    }

    public Drivetrain(
            TalonSRX leftMaster,
            TalonSRX rightMaster,
            VictorSPX leftSlave1,
            VictorSPX leftSlave2,
            VictorSPX rightSlave1,
            VictorSPX rightSlave2) {
        this.leftMaster = leftMaster;
        this.leftSlave1 = leftSlave1;
        this.leftSlave2 = leftSlave2;

        this.rightMaster = rightMaster;
        this.rightSlave1 = rightSlave1;
        this.rightSlave2 = rightSlave2;
    }

    @Override
    public void init() {
        setToBrake();
    }

    @Override
    public void readPeriodicInputs() {}

    @Override
    public void writePeriodicOutputs() {
        leftMaster.set(pIO.ctrlMode, pIO.leftOutput);
        rightMaster.set(pIO.ctrlMode, pIO.rightOutput);
    }

    @Override
    public void end() {
        setOpenloop(0, 0);
    }

    public void setToBrake() {
        leftMaster.setNeutralMode(NeutralMode.Brake);
        leftSlave1.setNeutralMode(NeutralMode.Brake);
        leftSlave2.setNeutralMode(NeutralMode.Brake);

        rightMaster.setNeutralMode(NeutralMode.Brake);
        rightSlave1.setNeutralMode(NeutralMode.Brake);
        rightSlave2.setNeutralMode(NeutralMode.Brake);
    }

    public void setOpenloop(double leftOutput, double rightOutput) {
        pIO.leftOutput = leftOutput;
        pIO.rightOutput = rightOutput;
    }

    public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
        WheelSpeeds ws = DifferentialDrive.curvatureDriveIK(xSpeed, zRotation, isQuickTurn);

        setOpenloop(ws.left, ws.right);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
}
