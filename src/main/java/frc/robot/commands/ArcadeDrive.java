// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Drivetrain drivetrain;
  private final DoubleSupplier leftSpeed, rightSpeed;

  /**
   * Creates a new ArcadeDrive command.
   *
   * @param drivetrain The subsystem used by this command.
   */
  public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    this.drivetrain = drivetrain;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.setLeftSpeed(leftSpeed.getAsDouble());
    drivetrain.setRightSpeed(rightSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setLeftSpeed(0);
    drivetrain.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
