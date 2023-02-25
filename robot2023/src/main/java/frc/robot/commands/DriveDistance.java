// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** A drive command that uses the Drive Train. */
// Written by mentor for more complex application of robot components
public class DriveDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final driveTrain m_drive;
  private final double m_distance;
  private final double m_speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param distance the distance driven by the robot
   * @param speed the speed at which the robot will drive
   * @param drive The drive subsystem used by this command.
   */
  public DriveDistance(double distance, double speed, driveTrain drive) {
    m_drive = drive;
    m_distance = distance; // measured in inches
    m_speed = speed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.encoderReset();
    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_drive.getAvgEncDistance()) >= m_distance;
  }
}
