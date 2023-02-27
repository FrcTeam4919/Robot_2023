package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelight extends SubsystemBase {

    private driveTrain m_driveTrain;

    public limelight() {
    }
    

    //aimcone called from autonomous command or aimcone command
    //aimcone in teleop called in Robot teleopperiodic while the key is pressed
    public void aimCone() {
        
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double left_command = 0;
        double right_command = 0;

        float Kp = -0.1f;
        float min_command = 0.05f;
        double heading_error = tx.getDouble(0.0);
        float steering_adjust = 0.0f;
        
        if (tx.getDouble(0.0) > 1.0)
        {
                steering_adjust = Kp * ((float)heading_error) - min_command;
        }
        else if (tx.getDouble(0.0) < 1.0)
        {
                steering_adjust = Kp * ((float)heading_error) + min_command;
        }

        //Left and right are for tank drive, need to convert it to arcade or create tankdrive
        // in the driveTrain subsystem (in addition to arcadedrive?)
        left_command += steering_adjust;
        right_command -= steering_adjust;

        m_driveTrain.limelightDrive(left_command, right_command);
    }

    public void aimRangeCone() {
        
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double left_command = 0;
        double right_command = 0;

        float Kp = -0.1f;
        float KpDistance = -0.1f;
        float min_command = 0.05f;
        double heading_error = tx.getDouble(0.0);
        double distance_error = -ty.getDouble(0.0);
        float steering_adjust = 0.0f;
        
        if (tx.getDouble(0.0) > 1.0)
        {
                steering_adjust = Kp * ((float)heading_error) - min_command;
        }
        else if (tx.getDouble(0.0) < 1.0)
        {
                steering_adjust = Kp * ((float)heading_error) + min_command;
        }
        
        double distance_adjust = KpDistance * distance_error;
        //Left and right are for tank drive, need to convert it to arcade or create tankdrive
        // in the driveTrain subsystem (in addition to arcadedrive?)
        left_command += steering_adjust + distance_adjust;
        right_command -= steering_adjust + distance_adjust;

        m_driveTrain.limelightDrive(left_command, right_command);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

