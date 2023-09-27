// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    CANSparkMax leftMotor;
    double motorSpeed;

    public Drivetrain() {
        leftMotor = new CANSparkMax(0, MotorType.kBrushless);
        motorSpeed = 0;
    }

    @Override
    public void periodic() {
        leftMotor.set(motorSpeed);
    }

    public void setSpeed(double speed) {
        motorSpeed = speed;
    }

    public double getSpeed() {
        return motorSpeed;
    }
}
