// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An extension command for Autonomous that uses the arm subsystem. */
public class ArmExtendDistance extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final arm m_arm;
  private final double m_distance;

  /**
   * 
   * @param distance the distance for the arm to extend to.
   * @param arm The arm subsystem used by this command.
   */
  public ArmExtendDistance(double distance, arm arm) {
    m_arm = arm;
    m_distance = distance;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.armEncoderReset();
    m_arm.extend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arm.extend();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_arm.getArmDistance()) >= m_distance;
  }
}
