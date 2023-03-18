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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants.ArmConstants;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class arm extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private DoubleSolenoid front1;
private DoubleSolenoid back1;
private DoubleSolenoid front2;
private DoubleSolenoid back2;
private Encoder armEncoder;
private CANSparkMax armMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public arm() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
//front1 = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 0, 1);
 
back1 = new DoubleSolenoid(2, PneumaticsModuleType.CTREPCM, 0, 1);
 
//front2 = new DoubleSolenoid(1, PneumaticsModuleType.REVPH, 2, 3);
 
back2 = new DoubleSolenoid(2, PneumaticsModuleType.CTREPCM, 2, 3);

armEncoder = new Encoder(4, 5, false, EncodingType.k4X);
 armEncoder.setDistancePerPulse(ArmConstants.kArmEncoderDistanceperPulse);

armMotor = new CANSparkMax(7, MotorType.kBrushed);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // etend extends arm out, temporery
    public void extend() {
       armMotor.set(0.5);
    }

    // retract retracts arm back in, temporery speed
    public void retract() {
        armMotor.set(-0.5);

    }

    // tilt arm action tilt claw up down
   /** public void tiltUpFront() {
        front1.set(Value.kForward);
        front2.set(Value.kForward);
    }

    public void tiltDownFront() {
        front1.set(Value.kReverse);
        front2.set(Value.kReverse);
       
    }
*/
    public void tiltUpBack() {
        back1.set(Value.kForward);
        back2.set(Value.kForward);
    }

    public void tiltDownBack() {
        back1.set(Value.kReverse);
        back2.set(Value.kReverse);
       
    }

    public void stop() {
        armMotor.set(0);
    }

    public void armEncoderReset() {
        armEncoder.reset();
    }

    public double getArmDistance() {
        return armEncoder.getDistance();
    }

    //

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
   // sam, if you read this then what wher you thinking by not tellig the build team how the motors are mounted/used
}

