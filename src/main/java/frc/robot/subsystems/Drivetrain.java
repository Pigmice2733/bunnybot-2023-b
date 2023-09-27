// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    CANSparkMax leftMotor, rightMotor;
    double leftSpeed, rightSpeed;

    public Drivetrain() {
        leftMotor = new CANSparkMax(0, MotorType.kBrushless);
        rightMotor = new CANSparkMax(1, MotorType.kBrushless);
        leftSpeed = rightSpeed = 0;
    }

    @Override
    public void periodic() {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }

    public void setLeftSpeed(double speed) {
        leftSpeed = speed;
    }

    public void setRightSpeed(double speed) {
        rightSpeed = speed;
    }

    public double getLeftSpeed() {
        return leftSpeed;
    }

    public double getRightSpeed() {
        return rightSpeed;
    }
}
