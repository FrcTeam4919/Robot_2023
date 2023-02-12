// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_VictorSPX left1;
private WPI_VictorSPX left2;
private WPI_VictorSPX left3;
private MotorControllerGroup left;
private WPI_VictorSPX right2;
private WPI_VictorSPX right1;
private WPI_VictorSPX right3;
private MotorControllerGroup right;
private DifferentialDrive differentialDrive1;
private DoubleSolenoid shiftleft;
private DoubleSolenoid shiftright;
private Encoder quadratureEncoderleft;
private Encoder quadratureEncoderright;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public driveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
left1 = new WPI_VictorSPX(1);
 
 

left2 = new WPI_VictorSPX(2);
 
 

left3 = new WPI_VictorSPX(3);
 
 

left = new MotorControllerGroup(left1, left2  );
 addChild("left",left);
 

right2 = new WPI_VictorSPX(5);
 
 

right1 = new WPI_VictorSPX(4);
 
 

right3 = new WPI_VictorSPX(6);
 
 

right = new MotorControllerGroup(right1, right2  );
 addChild("right",right);
 

differentialDrive1 = new DifferentialDrive(left, right);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.1);
differentialDrive1.setMaxOutput(1.0);


shiftleft = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 0, 1);
 addChild("shift left", shiftleft);
 

shiftright = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 2, 3);
 addChild("shift right", shiftright);
 

quadratureEncoderleft = new Encoder(0, 1, false, EncodingType.k4X);
 addChild("Quadrature Encoder left",quadratureEncoderleft);
 quadratureEncoderleft.setDistancePerPulse(1.0);

quadratureEncoderright = new Encoder(2, 3, false, EncodingType.k4X);
 addChild("Quadrature Encoder right",quadratureEncoderright);
 quadratureEncoderright.setDistancePerPulse(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    /**
     *   @param fwd 
     *   @param rot 
     * 
     */
     public void arcadeDrive(double fwd, double rot) {
        differentialDrive1.arcadeDrive(fwd , rot);
    }

    public void forward () {
        differentialDrive1.arcadeDrive(.5, 0); 
    }
    public void shiftHigh(){
        rightShift.set(true);
        leftShift.set(true);
    }
    public void shiftLow() {
        rightShift.set(false);
        leftShift.set(false);
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
  
