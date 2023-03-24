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

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.ADIS16448_IMU;
/**
 *
 */
public class driveTrain extends SubsystemBase {
    private final WPI_VictorSPX left1 = new WPI_VictorSPX(1);
    private final WPI_VictorSPX left2 = new WPI_VictorSPX(2);
    private final WPI_VictorSPX left3 = new WPI_VictorSPX(3);

    private final WPI_VictorSPX right1 = new WPI_VictorSPX(4);
    private final WPI_VictorSPX right2 = new WPI_VictorSPX(5);
    private final WPI_VictorSPX right3 = new WPI_VictorSPX(6);


    private final MotorControllerGroup left = new MotorControllerGroup(left1, left2 , left3 );
    private final MotorControllerGroup right = new MotorControllerGroup(right1, right2 , right3 );
    private final DifferentialDrive differentialDrive1 = new DifferentialDrive(left, right);


    private Encoder quadratureEncoderleft;
    private Encoder quadratureEncoderright;
   // private Solenoid rightShift;
    //private Solenoid leftShift;

    private DoubleSolenoid rightShift;
    private DoubleSolenoid leftShift;

//private AnalogGyro Gyro;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
  //Added Drive Straight
  private static final double kAngleSetpoint = 0.0;
  private static final double kP = 0.005; // propotional turning constant

  // gyro calibration constant, may need to be adjusted;
  // gyro value of 360 is set to correspond to one full revolution
  private static final double kVoltsPerDegreePerSecond = 0.0128;

  public static final ADIS16448_IMU imu = new ADIS16448_IMU();

  

    /**
    *
    */
    public driveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
       
 
 
        left.setInverted(false);
        right.setInverted(true);

        



quadratureEncoderleft = new Encoder(0, 1, false, EncodingType.k4X);
 addChild("Quadrature Encoder left",quadratureEncoderleft);
 quadratureEncoderleft.setDistancePerPulse(1.0);

quadratureEncoderright = new Encoder(2, 3, true, EncodingType.k4X);
 addChild("Quadrature Encoder right",quadratureEncoderright);
 quadratureEncoderright.setDistancePerPulse(1.0);

/**rightShift = new Solenoid(1, PneumaticsModuleType.REVPH, 11);
 addChild("rightShift", rightShift);
 

leftShift = new Solenoid(1, PneumaticsModuleType.REVPH, 13);
 addChild("leftShift", leftShift);
*/ 
/** Shifter double solenoid replacement code*/
  rightShift = new DoubleSolenoid(2, PneumaticsModuleType.CTREPCM, 6, 7);
  
  leftShift = new DoubleSolenoid(2, PneumaticsModuleType.CTREPCM, 4, 5);
 

 //Gyro = new AnalogGyro(0);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
   
    
    /**
     *   @param fwd 
     *   @param rot 
     * 
     */

     public void driveStraight(double fwd, double rot) {
        //replacing m_joystick.getY() with fwd, not sure this is correct

        //I wonder if kAngleSetpoint should be replaced with rot?
		double turningValue = (kAngleSetpoint - imu.getAngle()) * kP;

        // Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, fwd);

        differentialDrive1.arcadeDrive(fwd, turningValue);
	}
     public void arcadeDrive(double fwd, double rot) {
        differentialDrive1.arcadeDrive(fwd , rot);
    }

    public void limelightDrive(double left, double right) {
        differentialDrive1.tankDrive(left, right);
    }

    public void forward () {
        differentialDrive1.arcadeDrive(.5, 0); 
    }
    public void shiftHigh(){
        //rightShift.set(true);
        //leftShift.set(true);
        rightShift.set(Value.kReverse);
        leftShift.set(Value.kReverse);  
    }
    public void shiftLow() {
        //rightShift.set(false);
        //leftShift.set(false);
        rightShift.set(Value.kForward);
        leftShift.set(Value.kForward);
    }

    public static double gyroOutput() {
        return imu.getAngle();
    }

    public void encoderReset() {
        quadratureEncoderleft.reset();
        quadratureEncoderright.reset();
    }

    public double getAvgEncDistance() {
        return (quadratureEncoderleft.getDistance() + quadratureEncoderright.getDistance()) / 2.0;
    }

   // static final double kOffBalanceAngleThresholdDegrees = 10;
  //  static final double kOonBalanceAngleThresholdDegrees  = 5;
  //  public void balance(){
    
       
              
     // if ( gyroOutPut >= (koffBalanceAngleThreshold )  ) {
   //  } 
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


   
    public void dock() {
        if ( imu.getAccelY() >= .5) {
            differentialDrive1.arcadeDrive(.5, 0);
        }
        if (imu.getAccelY() <= -.5){
            differentialDrive1.arcadeDrive(-.5, 0);
        }
       else{
        differentialDrive1.arcadeDrive(0, 0);
       }
    }

}