package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.networktables.NetworkTableInstance

public class limelight extends SubsystemBase {
    private driveTrain m_driveTrain;
   
    public limelight(){}
public void aimCone(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
NetworkTableEntry tx = table.getEntry("tx");
NetworkTableEntry ty = table.getEntry("ty");
NetworkTableEntry ta = table.getEntry("ta");
float Kp = -0.1f;
float min_command = 0.05f;



        double heading_error = tx.getDouble(0.0) ;
        float steering_adjust = 0.0f;
        if(tx.getDouble(0.0)<1.0)
       { 
                if (heading_error < 0)
                {

                }
                else
                {

                }
        }
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

