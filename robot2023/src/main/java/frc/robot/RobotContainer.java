// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.tiltdownfront;
import frc.robot.commands.tiltupfront;
import frc.robot.commands.tiltdownback;
import frc.robot.commands.tiltupback;
import frc.robot.commands.out;
import frc.robot.commands.in;
import frc.robot.commands.open;
import frc.robot.commands.close;
import frc.robot.commands.defaultDrive;
import frc.robot.commands.aimCone;

import frc.robot.subsystems.arm;
import frc.robot.subsystems.claw;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.limelight;

import edu.wpi.first.wpilibj2.command.StartEndCommand;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // The robot's subsystems
  public final arm m_arm = new arm();
  public final compress m_compress = new compress();
  public final claw m_claw = new claw();
  public final driveTrain m_driveTrain = new driveTrain();
  public final limelight m_lightlight = new limelight();

  // Joysticks
  private final Joystick buttonBoard = new Joystick(1);
  private final Joystick joystick1 = new Joystick(0);

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  //commands
  private final tiltupfront m_Tiltupfront = new tiltupfront(m_arm);
  private final tiltdownfront m_Tiltdownfront = new tiltdownfront(m_arm);
  private final tiltupback m_Tiltupback = new tiltupback(m_arm);
  private final tiltdownback m_Tiltdownback = new tiltdownback(m_arm);
  private final in m_In = new in(m_arm);
  private final out m_Out = new out(m_arm);
  private final open m_Open = new open(m_claw);
  private final close m_Close = new close(m_claw);
  //private final aimCone m_aimCone = new aimCone(m_limelight);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // setup of buttons
  private JoystickButton tiltupfront = new JoystickButton(buttonBoard, 5);
  private JoystickButton tiltdownfront = new JoystickButton(buttonBoard, 2);
  private JoystickButton tiltupback = new JoystickButton(buttonBoard, 14);
  private JoystickButton tiltdownback = new JoystickButton(buttonBoard, 3);
  private JoystickButton in = new JoystickButton(buttonBoard, 6);
  private JoystickButton out = new JoystickButton(buttonBoard,15);
  private JoystickButton open = new JoystickButton(buttonBoard, 4);
  private JoystickButton close = new JoystickButton(buttonBoard, 1);
  private JoystickButton Shifter = new JoystickButton(joystick1, 1);
  private JoystickButton aimCone = new JoystickButton(buttonBoard, 7);


  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    //SmartDashboard.putData("tilt up", new tiltup( m_arm ));
    //SmartDashboard.putData("tilt down", new tiltdown( m_arm ));
    //SmartDashboard.putData("tilt up", new tiltup( m_arm ));
    //SmartDashboard.putData("tilt down", new tiltdown( m_arm ));
    SmartDashboard.putData("out", new out( m_arm ));
    SmartDashboard.putData("in", new in( m_arm ));
    SmartDashboard.putData("open", new open( m_claw ));
    SmartDashboard.putData("close", new close( m_claw ));
    SmartDashboard.putData("aimCone", new aimCone( m_lightlight ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_driveTrain.setDefaultCommand(
        new defaultDrive(joystick1::getY, joystick1::getX, m_driveTrain));
         
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
  

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    tiltupfront.onTrue(m_Tiltupfront);
    tiltdownfront.onTrue(m_Tiltdownfront);
    tiltupback.onTrue(m_Tiltupback);
    tiltdownback.onTrue(m_Tiltdownback);
    in.whileTrue(m_In);
    out.whileTrue(m_Out);
    open.onTrue(m_Open);
    close.onTrue(m_Close);
    //aimCone.onTrue(m_aimCone);

   Shifter.toggleOnTrue(new StartEndCommand(m_driveTrain::shiftHigh, m_driveTrain::shiftLow, m_driveTrain));


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    // Create some buttons


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public Joystick getJoystick1() {
    return joystick1;
  }

  public Joystick getButtonboard() {
    return buttonBoard;
  }


  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  // buttons
   
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
}

